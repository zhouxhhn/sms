/*
 * (C) Copyright 2018 Siyue Holding Group.
 */
package cn.siyue.platform.sms.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.sms.client.callback.SmsServiceFallBack;
import cn.siyue.platform.sms.client.callback.SmsTypeServiceFallBack;
import cn.siyue.platform.sms.pojo.SiyueSmsType;

/**
 * 调用短信服务生产者的接口
 */
@FeignClient(name = "sms-service", fallback = SmsTypeServiceFallBack.class)
public interface SmsTypeService {

  @RequestMapping(value = "/siyue/smsType/addSmsType", method = RequestMethod.POST)
  ResponseData addSmsType(SiyueSmsType siyueSmsType);

  @RequestMapping(value = "/siyue/smsType/updateSmsType", method = RequestMethod.PUT)
  ResponseData updateSmsType(SiyueSmsType siyueSmsType);

  @RequestMapping(value = "/siyue/smsType/deleteSmsType", method = RequestMethod.DELETE)
  ResponseData deleteSmsType(@RequestParam("id") Long id);

  @RequestMapping(value = "/siyue/smsType/searchAllSmsType", method = RequestMethod.DELETE)
  ResponseData searchAllSmsType(@RequestParam("page") int page, @RequestParam("size") int size);

  @RequestMapping(value = "/siyue/smsType/searchSigleSmsType", method = RequestMethod.GET)
  ResponseData searchSigleSmsType(@RequestParam("id") Long id);


}
