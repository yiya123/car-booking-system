package com.example.carbookingsystem.config;


import io.swagger.annotations.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {


    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("Lisa Yang")
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(GetMapping.class))
                .paths(PathSelectors.any())
                .build();
    }


    @Bean
    public ApiInfo apiInfo(){
        Contact contact = new Contact("Lisa Yang",
                "http://www.baidu.com", "1430369130@qq.com");

        return new ApiInfo("CarBookingSystem","Providing the service of renting cars","v-1.0",
                "localhost:8080", contact,"SpringBoot 2.7.8",
                "http://www.baidu.com",new ArrayList());
    }
}
