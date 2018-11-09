package cn.siyue.platform.sms.server.service;

import com.baomidou.mybatisplus.service.IService;

import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.sms.pojo.SiyueSms;
import cn.siyue.platform.sms.pojo.SiyueSmsType;

/**
 * <p>
 * 短信表 服务类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
public interface SiyueSmsServiceContract extends IService<SiyueSms> {

  /**
   * 发送验证码
   */
    ResponseData sendSms(SiyueSmsType siyueSmsType);

}
