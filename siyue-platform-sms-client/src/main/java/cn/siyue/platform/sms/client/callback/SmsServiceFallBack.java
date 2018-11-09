/*
 * (C) Copyright 2018 Siyue Holding Group.
 */
package cn.siyue.platform.sms.client.callback;

import org.springframework.stereotype.Component;
import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.constants.ResponseBackCode;
import cn.siyue.platform.sms.client.service.SmsService;
import cn.siyue.platform.sms.pojo.SiyueSms;
import cn.siyue.platform.sms.pojo.SiyueSmsType;

/**
 * 个人地址管理熔断器
 */
@Component
public class SmsServiceFallBack implements SmsService {

  @Override
  public ResponseData sendSms(SiyueSmsType siyueSmsType) {
    return ResponseData.build(
        ResponseBackCode.ERROR_DOWNGRADE.getValue(),
        ResponseBackCode.ERROR_DOWNGRADE.getMessage()
    );
  }
}
