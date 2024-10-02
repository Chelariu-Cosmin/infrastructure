package ro.infrastructure.be.configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@io.swagger.v3.oas.annotations.security.SecurityScheme(
        name = "Bearer Authentication",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class OpenApiConfig {
    @Bean
    public GroupedOpenApi apiV1() {
        return GroupedOpenApi.builder()
                .group("v1")
                .pathsToMatch("/api/v1/**")
                .build();
    }

    @Bean
    public GroupedOpenApi apiV2() {
        return GroupedOpenApi.builder()
                .group("v2")
                .pathsToMatch("/api/v2/**")
                .build();
    }

    @Bean
    public OpenAPI openAPI(@Value("${springdoc.api-docs.version}") String appVersion, @Value("${application.host}") String url) {
        Server server = new Server();
        server.setUrl(url);
        server.setDescription("Server URL in Development environment");
        return new OpenAPI()
                .components(new Components())
                .servers(List.of(server))
                .info(new Info().title("Driver Master API")
                        .description("This API exposes endpoints to manage internal processes for a driving school.")
                        .version(appVersion)
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}