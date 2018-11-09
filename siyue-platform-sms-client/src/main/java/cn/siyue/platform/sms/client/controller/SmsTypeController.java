/*
 * (C) Copyright 2018 Siyue Holding Group.
 */
package cn.siyue.platform.sms.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.constants.ResponseBackCode;
import cn.siyue.platform.sms.client.service.SmsTypeService;
import cn.siyue.platform.sms.pojo.SiyueSmsType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 短信类型管理类
 */
@Api(tags = "斯越_短信类型接口")
@RequestMapping(path = "/siyue/smsType", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
public class SmsTypeController {

  @Autowired
  private SmsTypeService smsTypeService;

  /**
   * 增加短信类型
   */
  @ApiOperation(nickname = "smsTypeAddSmsType",value = "增加短信类型", httpMethod = "POST")
  @PostMapping("/addSmsType")
  public ResponseData addSmsType(@RequestBody @Valid SiyueSmsType siyueSmsType,
                                 BindingResult result) {
    //请求的数据参数格式不正确
    if (result.hasErrors()) {
      return ResponseData.build(
          ResponseBackCode.ERROR_PARAM_INVALID.getValue(),
          ResponseBackCode.ERROR_PARAM_INVALID.getMessage()
      );
    }
    return smsTypeService.addSmsType(siyueSmsType);
  }

  /**
   * 修改短信类型
   */
  @ApiOperation(nickname = "smsTypeUpdateSmsType",value = "修改短信类型", httpMethod = "PUT")
  @PutMapping("/updateSmsType")
  public ResponseData updateSmsType(@RequestBody @Valid SiyueSmsType siyueSmsType,
                                 BindingResult result) {
    //请求的数据参数格式不正确
    if (result.hasErrors()) {
      return ResponseData.build(
          ResponseBackCode.ERROR_PARAM_INVALID.getValue(),
          ResponseBackCode.ERROR_PARAM_INVALID.getMessage()
      );
    }
    return smsTypeService.updateSmsType(siyueSmsType);
  }

  /**
   * 删除短信类型
   */
  @ApiOperation(nickname = "smsTypeDeleteSmsType",value = "删除短信类型", httpMethod = "DELETE")
  @DeleteMapping("/deleteSmsType")
  public ResponseData deleteSmsType(@RequestParam("id") Long id) {
    return smsTypeService.deleteSmsType(id);
  }

  /**
   * 查找所有短信类型数据
   */
  @ApiOperation(nickname = "smsTypeSearchAllSmsType",value = "查找所有短信类型数据", httpMethod = "GET")
  @GetMapping("/searchAllSmsType")
  public ResponseData searchAllSmsType(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                         @RequestParam(value = "size", required = false, defaultValue = "15") int size) {
    try {
      return smsTypeService.searchAllSmsType(page, size);

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
  @ApiOperation(nickname = "smsTypeSearchSingleSmsType",value = "查找单个短信类型数据", httpMethod = "GET")
  @GetMapping("/searchSigleSmsType")
  public ResponseData searchSingleRights(
      @RequestParam("id") Long id
  ) {
    try {
      return smsTypeService.searchSigleSmsType(id);
    } catch (Exception e) {
      return ResponseData.build(
          ResponseBackCode.ERROR_FAIL.getValue(),
          ResponseBackCode.ERROR_FAIL.getMessage()
      );
    }
  }
}
