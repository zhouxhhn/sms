/*
 * (C) Copyright 2018 Siyue Holding Group.
 */
package cn.siyue.platform.sms.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger {

  @Bean
  public Docket createRestApi() {
    ParameterBuilder tokenPar = new ParameterBuilder();
    List<Parameter> pars = new ArrayList<>();
    tokenPar.name("token").description("令牌")
        .modelRef(new ModelRef("string")).parameterType("header").required(false).build();
    pars.add(tokenPar.build());
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("cn.siyue.platform.sms.client.controller"))
        .paths(PathSelectors.any())
        .build().globalOperationParameters(pars);
  }

  @SuppressWarnings("deprecation")
  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("斯越短信服务接口")
        .description("Siyue API document")
        .contact("Siyue Develop Team")
        .version("1.0")
        .build();
  }
}
