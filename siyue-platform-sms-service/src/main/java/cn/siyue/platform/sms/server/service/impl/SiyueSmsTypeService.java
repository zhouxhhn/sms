package cn.siyue.platform.sms.server.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import cn.siyue.platform.sms.pojo.SiyueSmsType;
import cn.siyue.platform.sms.server.mapper.SiyueSmsTypeMapper;
import cn.siyue.platform.sms.server.service.SiyueSmsTypeServiceContract;

/**
 * <p>
 * 短信类型表 服务实现类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
@Primary
@Service
public class SiyueSmsTypeService extends ServiceImpl<SiyueSmsTypeMapper, SiyueSmsType> implements SiyueSmsTypeServiceContract {

}
