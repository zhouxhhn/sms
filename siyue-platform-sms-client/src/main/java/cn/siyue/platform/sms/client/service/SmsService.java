/*
 * (C) Copyright 2018 Siyue Holding Group.
 */
package cn.siyue.platform.sms.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.sms.client.callback.SmsServiceFallBack;
import cn.siyue.platform.sms.pojo.SiyueSmsType;

/**
 * 调用短信服务生产者的接口
 */
@FeignClient(name = "sms-service", fallback = SmsServiceFallBack.class)
public interface SmsService {

  @RequestMapping(value = "/siyue/sms/sendSms", method = RequestMethod.POST)
  ResponseData sendSms(SiyueSmsType siyueSmsType);

}
