package com.solstice.employeetree.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfo("Employee Tree", "Employee Tree API", "1.0",
                        null, null, null, null, Collections.emptyList()))
                .tags(new Tag("employeeTree", "Employee Tree Service"))
                .useDefaultResponseMessages(false)
                .select().paths(regex("/employees.*")).build();
    }
}
