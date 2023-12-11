package org.suehay.microservicesorder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApi {

    @Bean
    public io.swagger.v3.oas.models.OpenAPI customOpenAPI() {
        return new io.swagger.v3.oas.models.OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("Suehay's Products API")
                        .version("1.0.0")
                        .description("Products API v1.0.0")
                        .termsOfService("http://swagger.io/terms/"));
    }
}