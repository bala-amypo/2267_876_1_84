@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Vehicle Service History API")
                        .version("1.0")
                        .description("API for Vehicle, Garage, Service Entries, Parts and Verification"))
                .servers(List.of(
                        new Server()
                                .url("https://9157.32procr.amypo.ai")
                                .description("Production Server")
                ));
    }
}
