/*
 * (C) Copyright 2018 Siyue Holding Group.
 */
package cn.siyue.platform.sms.server.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.constants.ResponseBackCode;
import cn.siyue.platform.sms.pojo.SiyueSmsType;
import cn.siyue.platform.sms.server.service.SiyueSmsServiceContract;
import cn.siyue.platform.sms.server.service.SiyueSmsTypeServiceContract;

/**
 * 短信类型管理类
 */
@RequestMapping(path = "/siyue/smsType", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
public class SmsTypeController {

  @Autowired
  private SiyueSmsTypeServiceContract siyueSmsTypeService;

  /**
   * 增加短信类型
   */
  @PostMapping("/addSmsType")
  public ResponseData addSmsType(@RequestBody SiyueSmsType siyueSmsType) {
    try {
       siyueSmsTypeService.insert(siyueSmsType);
       return ResponseData.build(
          ResponseBackCode.SUCCESS.getValue(),
          ResponseBackCode.SUCCESS.getMessage(),siyueSmsType);
    } catch (Exception e) {
      return ResponseData.build(
          ResponseBackCode.ERROR_CREATE_FAIL.getValue(),
          ResponseBackCode.ERROR_CREATE_FAIL.getMessage()
      );
    }
  }

  /**
   * 修改短信类型
   */
  @PutMapping("/updateSmsType")
  public ResponseData updateSmsType(@RequestBody SiyueSmsType siyueSmsType) {
    try {
      siyueSmsTypeService.insert(siyueSmsType);
      return ResponseData.build(
          ResponseBackCode.SUCCESS.getValue(),
          ResponseBackCode.SUCCESS.getMessage(),siyueSmsType);
    } catch (Exception e) {
      return ResponseData.build(
          ResponseBackCode.ERROR_CREATE_FAIL.getValue(),
          ResponseBackCode.ERROR_CREATE_FAIL.getMessage()
      );
    }
  }

  /**
   * 删除短信类型
   */
  @DeleteMapping("/deleteSmsType")
  public ResponseData deleteSmsType(@RequestParam("id") Long id) {
    try {
      siyueSmsTypeService.deleteById(id);
      return ResponseData.build(
          ResponseBackCode.SUCCESS.getValue(),
          ResponseBackCode.SUCCESS.getMessage());
    } catch (Exception e) {
      return ResponseData.build(
          ResponseBackCode.ERROR_CREATE_FAIL.getValue(),
          ResponseBackCode.ERROR_CREATE_FAIL.getMessage()
      );
    }
  }

  /**
   * 查找单个短信类型数据
   */
  @GetMapping("/searchSigleSmsType")
  public ResponseData searchSigleSmsType(@RequestParam("id") Long id) {
    try {
      SiyueSmsType siyueSmsType = siyueSmsTypeService.selectById(id);
      return ResponseData.build(
          ResponseBackCode.SUCCESS.getValue(),
          ResponseBackCode.SUCCESS.getMessage(),siyueSmsType);
    } catch (Exception e) {
      return ResponseData.build(
          ResponseBackCode.ERROR_CREATE_FAIL.getValue(),
          ResponseBackCode.ERROR_CREATE_FAIL.getMessage()
      );
    }
  }


  /**
   * 查找所有短信类型
   */
  @GetMapping("/searchAllSmsType")
  public ResponseData searchAllSmsType(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                    @RequestParam(value = "size", required = false, defaultValue = "15") int size) {
    try {
      Page userPage = new Page<SiyueSmsType>(page, size);
      userPage.setAsc(false);
      userPage = siyueSmsTypeService.selectPage(userPage);
      return ResponseData.build(
          ResponseBackCode.SUCCESS.getValue(),
          ResponseBackCode.SUCCESS.getMessage(),userPage);
    } catch (Exception e) {
      return ResponseData.build(
          ResponseBackCode.ERROR_CREATE_FAIL.getValue(),
          ResponseBackCode.ERROR_CREATE_FAIL.getMessage()
      );
    }
  }
}
