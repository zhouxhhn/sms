/*
 * (C) Copyright 2018 Siyue Holding Group.
 */
package cn.siyue.platform.sms.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 短信服务消费的应用
 */
@EnableCircuitBreaker
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"cn.siyue.platform.sms.client.*","cn.siyue.platform.*"})
public class SmsClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(SmsClientApplication.class);
  }
}
