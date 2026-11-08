package uz.pdp;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "PDP G61 Post Todo Comment Project",
                version = "10",
                contact = @Contact(
                        name = "Ali Aliyev",
                        email = "john.lgd65@gmail.com",
                        url = "https://github.com/jlkesh"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://springdoc.org"),
                termsOfService = "http://swagger.io/terms/",
                description = "Spring 6 Swagger Simple Application"
        ),
        externalDocs = @ExternalDocumentation(
                description = "Spring 6 Wiki Documentation",
                url = "https://springshop.wiki.github.org/docs"
        ),
        servers = {
                @Server(
                        url = "http://localhost:8080",
                        description = "Production-Server"
                ),
                @Server(
                        url = "http://localhost:9090",
                        description = "Test-Server"
                )
        }
)
public class Lesson10Application {

    public static void main(String[] args) {
        SpringApplication.run(Lesson10Application.class, args);
    }



    @Bean
    public GroupedOpenApi postGroupAPI() {
        return GroupedOpenApi.builder()
                .group("PostController")
                .pathsToMatch("/api/posts/**")
                .build();
    }

    @Bean
    public GroupedOpenApi todoGroupAPI() {
        return GroupedOpenApi.builder()
                .group("TodoController")
                .pathsToMatch("/api/todos/**")
                .build();
    }

    @Bean
    public GroupedOpenApi commentGroupAPI() {
        return GroupedOpenApi.builder()
                .group("CommentController")
                .pathsToMatch("/api/comment/**")
                .build();
    }


}
