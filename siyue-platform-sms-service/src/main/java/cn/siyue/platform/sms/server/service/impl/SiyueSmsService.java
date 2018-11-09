package cn.siyue.platform.sms.server.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.constants.ResponseBackCode;
import cn.siyue.platform.sms.pojo.SiyueSms;
import cn.siyue.platform.sms.pojo.SiyueSmsType;
import cn.siyue.platform.sms.server.config.SmsConfig;
import cn.siyue.platform.sms.server.constants.SmsConstants;
import cn.siyue.platform.sms.server.mapper.SiyueSmsMapper;
import cn.siyue.platform.sms.server.service.SiyueSmsServiceContract;
import cn.siyue.platform.sms.server.service.SiyueSmsTypeServiceContract;

/**
 * 短信表 服务实现类
 */
@Primary
@Service
public class SiyueSmsService extends ServiceImpl<SiyueSmsMapper, SiyueSms> implements SiyueSmsServiceContract {

  @Autowired
  private JedisClusterServiceImpl jedisClusterService;

  @Autowired
  private SiyueSmsTypeServiceContract  siyueSmsTypeService;

  @Autowired
  private SmsConfig smsConfig;

  private static String ENCODING = "UTF-8";

  /**
   * 发送验证码
   */
  @Transactional(rollbackFor = Exception.class)
  @Override
  public ResponseData sendSms(SiyueSmsType siyueSmsType) {
    String code = createCode();

    Map map = new HashMap();
    map.put("platform",siyueSmsType.getPlatform());
    map.put("type",siyueSmsType.getType());
    List<SiyueSmsType> list =  siyueSmsTypeService.selectByMap(map);
    if(list == null || list.size() == 0){
      return ResponseData.build(ResponseBackCode.ERROR_PARAM_INVALID.getValue(),
                                ResponseBackCode.ERROR_PARAM_INVALID.getMessage());
    }
    String text = list.get(0).getContent();
    text = text.replace("#code#",code);

    //发送短信
    Map < String, String > params = new HashMap< String, String >();
    params.put("apikey", smsConfig.getApikey());
    params.put("text", text);
    params.put("mobile", siyueSmsType.getCellphone());
    String results = post(smsConfig.getUri_send_sms(), params);

    //把短信内容插入到数据库
    SiyueSms siyueSms = new SiyueSms();
    siyueSms.setCellphone(siyueSmsType.getCellphone());
    siyueSms.setContent(text);
    insert(siyueSms);

    //把验证码放入redis里
    jedisClusterService.set(siyueSmsType.getCellphone() + ":" + code, siyueSmsType.getCellphone());

    //设置session的过期时间
    jedisClusterService.expire(siyueSmsType.getCellphone() + ":" + code, SmsConstants.SSO_SESSION_EXPIRE);

    return ResponseData.build(ResponseBackCode.SUCCESS.getValue(),
                              ResponseBackCode.SUCCESS.getMessage(), results);
  }

  /**
   * 随机生成6位数字验证码
   */
  private String createCode(){
    String str="0123456789";
    StringBuilder sb=new StringBuilder(6);
    for(int i=0;i<6;i++)
    {
      char ch=str.charAt(new Random().nextInt(str.length()));
      sb.append(ch);
    }
    return sb.toString();
  }


  private String post(String url, Map< String, String > paramsMap) {
    CloseableHttpClient client = HttpClients.createDefault();
    String responseText = "";
    CloseableHttpResponse response = null;
    try {
      HttpPost method = new HttpPost(url);
      if (paramsMap != null) {
        List< NameValuePair > paramList = new ArrayList<
            NameValuePair >();
        for (Map.Entry < String, String > param: paramsMap.entrySet()) {
          NameValuePair pair = new BasicNameValuePair(param.getKey(),
                                                      param.getValue());
          paramList.add(pair);
        }
        method.setEntity(new UrlEncodedFormEntity(paramList,
                                                  ENCODING));
      }
      response = client.execute(method);
      HttpEntity entity = response.getEntity();
      if (entity != null) {
        responseText = EntityUtils.toString(entity, ENCODING);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        response.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return responseText;
  }
}
