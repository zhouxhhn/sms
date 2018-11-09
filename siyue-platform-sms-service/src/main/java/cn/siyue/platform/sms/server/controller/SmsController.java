/*
 * (C) Copyright 2018 Siyue Holding Group.
 */
package cn.siyue.platform.sms.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.constants.ResponseBackCode;
import cn.siyue.platform.sms.pojo.SiyueSms;
import cn.siyue.platform.sms.pojo.SiyueSmsType;
import cn.siyue.platform.sms.server.service.SiyueSmsServiceContract;

/**
 * 短信服务类
 */
@RequestMapping(path = "/siyue/sms", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
public class SmsController {

  @Autowired
  private SiyueSmsServiceContract siyueSmsService;

  /**
   * 发送短信
   */
  @PostMapping("/sendSms")
  public ResponseData sendSms(@RequestBody SiyueSmsType siyueSmsType) {
    try {
      return siyueSmsService.sendSms(siyueSmsType);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseData.build(
          ResponseBackCode.ERROR_CREATE_FAIL.getValue(),
          ResponseBackCode.ERROR_CREATE_FAIL.getMessage()
      );
    }
  }
}
