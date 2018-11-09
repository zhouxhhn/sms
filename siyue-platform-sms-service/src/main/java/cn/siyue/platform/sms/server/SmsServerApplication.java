/*
 * (C) Copyright 2018 Siyue Holding Group.
 */
package cn.siyue.platform.sms.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 短信服务入口类
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"cn.siyue.platform.sms.server.*", "cn.siyue.platform.*"})
@MapperScan("cn.siyue.platform.sms.server*")
public class SmsServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(SmsServerApplication.class);
  }
}
