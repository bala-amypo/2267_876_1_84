package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {

        // 🔴 IMPORTANT: This MUST match your Swagger UI domain
        Server hostedServer = new Server();
        hostedServer.setUrl("https://9157.32procr.amypo.ai");
        hostedServer.setDescription("Hosted API Server");

        return new OpenAPI()
                .info(new Info()
                        .title("Vehicle Service History API")
                        .description("All APIs return 200 OK")
                        .version("1.0.0"))
                .servers(List.of(hostedServer));
    }
}
