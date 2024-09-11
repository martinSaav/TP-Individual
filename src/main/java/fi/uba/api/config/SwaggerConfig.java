package fi.uba.api.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.examples.Example;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.responses.ApiResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;


@OpenAPIDefinition
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI getApiInfo() {

        ApiResponse okAPI = new ApiResponse().content(
                new Content().addMediaType(MediaType.APPLICATION_JSON_VALUE,
                        new io.swagger.v3.oas.models.media.MediaType().addExamples("default",
                                new Example().value("{\"code\" : 200, \"Status\" : \"Ok!\", \"Message\" : \"Successfully retrieved!\"}")))
        );

        ApiResponse updatedAPI = new ApiResponse().content(
                new Content().addMediaType(MediaType.APPLICATION_JSON_VALUE,
                        new io.swagger.v3.oas.models.media.MediaType().addExamples("default",
                                new Example().value("{\"code\" : 200, \"Status\" : \"Ok!\", \"Message\" : \"A record has been updated!\"}")))
        );

        ApiResponse createdAPI = new ApiResponse().content(
                new Content().addMediaType(MediaType.APPLICATION_JSON_VALUE,
                        new io.swagger.v3.oas.models.media.MediaType().addExamples("default",
                                new Example().value("{\"code\" : 201, \"Status\" : \"Created!\", \"Message\" : \"A record has been successfully created!\"}")))
        );

        ApiResponse noContentAPI = new ApiResponse().content(
                new Content().addMediaType(MediaType.APPLICATION_JSON_VALUE,
                        new io.swagger.v3.oas.models.media.MediaType().addExamples("default",
                                new Example().value("{\"code\" : 204, \"Status\" : \"NoContent!\", \"Message\" : \"No content to respond with!\"}")))
        );

        ApiResponse badRequestAPI = new ApiResponse().content(
                new Content().addMediaType(MediaType.APPLICATION_JSON_VALUE,
                        new io.swagger.v3.oas.models.media.MediaType().addExamples("default",
                                new Example().value("{\"code\" : 400, \"Status\" : \"BadRequest!\", \"Message\" : \"The request is not valid!\"}")))
        );

        ApiResponse unauthorizedAPI = new ApiResponse().content(
                new Content().addMediaType(MediaType.APPLICATION_JSON_VALUE,
                        new io.swagger.v3.oas.models.media.MediaType().addExamples("default",
                                new Example().value("{\"code\" : 401, \"Status\" : \"Unauthorized!\", \"Message\" : \"The credentials are not valid!\"}")))
        );

        ApiResponse notFoundAPI = new ApiResponse().content(
                new Content().addMediaType(MediaType.APPLICATION_JSON_VALUE,
                        new io.swagger.v3.oas.models.media.MediaType().addExamples("default",
                                new Example().value("{\"code\" : 404, \"Status\" : \"NotFound!\", \"Message\" : \"No record found!\"}")))
        );

        ApiResponse internalServerErrorAPI = new ApiResponse().content(
                new Content().addMediaType(MediaType.APPLICATION_JSON_VALUE,
                        new io.swagger.v3.oas.models.media.MediaType().addExamples("default",
                                new Example().value("{\"code\" : 500, \"Status\" : \"InternalServerError!\", \"Message\" : \"An unexpected error occurred on the server!\"}")))
        );

        Components components = new Components();
        components.addResponses("okAPI", okAPI);
        components.addResponses("notFoundAPI", notFoundAPI);
        components.addResponses("createdAPI", createdAPI);
        components.addResponses("UnauthorizedAPI", unauthorizedAPI);
        components.addResponses("badRequestAPI", badRequestAPI);
        components.addResponses("updatedAPI", updatedAPI);
        components.addResponses("noContentAPI", noContentAPI);
        components.addResponses("internalServerErrorAPI", internalServerErrorAPI);

        return new OpenAPI()
                .openapi("3.0.1")
                .components(components)
                .info(new Info()
                        .title("SnapMsg")
                        .version("v1")
                        .description("APIREST SnapMsg")
                        .termsOfService("https://swagger.io/terms/")
                        .contact(new Contact()
                                .name("Martin Estrada")
                                .email("martintheduck1@gmail.com")
                                .url("https://github.com/martinSaav"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0.html"))
                );
    }
}
