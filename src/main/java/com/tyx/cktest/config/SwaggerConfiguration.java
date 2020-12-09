package com.tyx.cktest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: cktest
 * @description: swagger配置类
 * @author: tyx
 * @create: 2020-11-23 20:47
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInfo())
                .select()
                // 指定package下的接口显示在接口文档中
                .apis(RequestHandlerSelectors.basePackage("com.tyx.cktest.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
                .title("swagger接口文档")
                .contact(new Contact("benqi",null,"962475388@qq.com"))
                .description("测试平台接口文档")
                .termsOfServiceUrl("https://github.com/linlinjava/litemall")
                .version("1.0")
                .build();
    }
}

