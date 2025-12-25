package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.responses.ApiResponses;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Vehicle Service History API")
                        .version("1.0")
                        .description("All APIs return 200 OK in Swagger"));
    }

    /**
     * This removes all default error responses from Swagger UI
     * and leaves ONLY 200 OK.
     */
    @Bean
    public OpenApiCustomizer hideErrorResponsesCustomizer() {
        return openApi -> openApi.getPaths().values().forEach(pathItem ->
                pathItem.readOperations().forEach(operation -> {
                    ApiResponses responses = new ApiResponses();
                    responses.addApiResponse(
                            "200",
                            new ApiResponse()
                                    .description("OK")
                                    .content(new Content()
                                            .addMediaType(
                                                    "application/json",
                                                    new MediaType()
                                            )
                                    )
                    );
                    operation.setResponses(responses);
                })
        );
    }
}
