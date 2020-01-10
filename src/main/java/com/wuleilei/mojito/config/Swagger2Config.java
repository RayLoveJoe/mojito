package com.wuleilei.mojito.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//标记配置类
@Configuration
//开启在线接口文档
@EnableSwagger2
public class Swagger2Config {
    /**
     * 添加摘要信息(Docket)
     */
    @Bean
    public Docket controllerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("RayLoveJoe:Mojito接口文档")
                        .description("用于管理小程序接口文档信息")
                        .contact(new Contact("吴磊磊", null, "576484415@qq.com"))
                        .version("版本号:1.0")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wuleilei.wang.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
