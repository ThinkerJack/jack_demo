package com.note.app.note_app.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
@EnableOpenApi
@Configuration
  public class SwaggerConfig {
     @Bean
     public Docket createRestApi() {
                 return new Docket(DocumentationType.OAS_30)
                         .apiInfo(apiInfo())
                         .select()
                         .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                         .paths(PathSelectors.any())
                         .build(); }// API基础信息定义（就是更新Swagger默认页面上的信息）

            private ApiInfo apiInfo() {
               return new ApiInfoBuilder()
                      .title("Swagger3接口文档测试")
                     .description("文档描述：更多问题，请联系开发者")
                     .version("1.0")
                    .build();
        }

    }