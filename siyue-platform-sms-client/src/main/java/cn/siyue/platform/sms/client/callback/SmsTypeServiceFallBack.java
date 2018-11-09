/*
 * (C) Copyright 2018 Siyue Holding Group.
 */
package cn.siyue.platform.sms.client.callback;

import org.springframework.stereotype.Component;

import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.constants.ResponseBackCode;
import cn.siyue.platform.sms.client.service.SmsService;
import cn.siyue.platform.sms.client.service.SmsTypeService;
import cn.siyue.platform.sms.pojo.SiyueSmsType;

/**
 * 短信类型熔断器
 */
@Component
public class SmsTypeServiceFallBack implements SmsTypeService {

  @Override public ResponseData addSmsType(SiyueSmsType siyueSmsType) {
    return ResponseData.build(
        ResponseBackCode.ERROR_DOWNGRADE.getValue(),
        ResponseBackCode.ERROR_DOWNGRADE.getMessage()
    );
  }

  @Override public ResponseData updateSmsType(SiyueSmsType siyueSmsType) {
    return ResponseData.build(
        ResponseBackCode.ERROR_DOWNGRADE.getValue(),
        ResponseBackCode.ERROR_DOWNGRADE.getMessage()
    );
  }

  @Override public ResponseData deleteSmsType(Long id) {
    return ResponseData.build(
        ResponseBackCode.ERROR_DOWNGRADE.getValue(),
        ResponseBackCode.ERROR_DOWNGRADE.getMessage()
    );
  }

  @Override public ResponseData searchAllSmsType(int page, int size) {
    return ResponseData.build(
        ResponseBackCode.ERROR_DOWNGRADE.getValue(),
        ResponseBackCode.ERROR_DOWNGRADE.getMessage()
    );
  }

  @Override public ResponseData searchSigleSmsType(Long id) {
    return ResponseData.build(
        ResponseBackCode.ERROR_DOWNGRADE.getValue(),
        ResponseBackCode.ERROR_DOWNGRADE.getMessage()
    );
  }
}
