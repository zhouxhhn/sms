/*
 * (C) Copyright 2018 Siyue Holding Group.
 */
package cn.siyue.platform.sms.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.constants.ResponseBackCode;
import cn.siyue.platform.sms.client.service.SmsService;
import cn.siyue.platform.sms.pojo.SiyueSms;
import cn.siyue.platform.sms.pojo.SiyueSmsType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "斯越_短信接口")
@RequestMapping(path = "/siyue/sms", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
public class SmsController {

  @Autowired
  private SmsService smsService;

  @ApiOperation(nickname = "smsSendSms",value = "发送短信接口", httpMethod = "POST")
  @PostMapping("/sendSms")
  public ResponseData sendSms(@RequestBody @Valid SiyueSmsType siyueSmsType,
                              BindingResult result) {
    //请求的数据参数格式不正确
    if (result.hasErrors()) {
      return ResponseData.build(
          ResponseBackCode.ERROR_PARAM_INVALID.getValue(),
          ResponseBackCode.ERROR_PARAM_INVALID.getMessage()
      );
    }
    return smsService.sendSms(siyueSmsType);
  }
}
