package com.kfreemarket.reemarket_server.global.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(info);
    }

    Info info = new Info().title("K-FreeMarket API").version("0.0.1").description(
            "<h3>K-FreeMarket API</h3> </br> <p>제작자 : 정승근 (wjd15sheep@gmail.com) </br> 제작 기간 : 2025.05.24 ~ 2025.00.00 </br> API의 명세서 입니다.<p>"
    );
}
