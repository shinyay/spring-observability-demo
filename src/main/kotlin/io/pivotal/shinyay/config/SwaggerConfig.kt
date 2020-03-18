package io.pivotal.shinyay.config

import org.springframework.boot.info.BuildProperties
import org.springframework.boot.info.GitProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger.web.*
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.util.*

@Configuration
@EnableSwagger2
class SwaggerConfig(var build: Optional<BuildProperties>,
                    var git: Optional<GitProperties>) {

    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/persons/**"))
                .build()
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
    }

    @Bean
    fun uiConfig(): UiConfiguration {
        return UiConfigurationBuilder.builder()
                .deepLinking(true)
                .displayOperationId(true)
                .defaultModelsExpandDepth(1)
                .defaultModelExpandDepth(1)
                .defaultModelRendering(ModelRendering.MODEL)
                .displayRequestDuration(false)
                .docExpansion(DocExpansion.LIST)
                .filter(false)
                .maxDisplayedTags(null)
                .operationsSorter(OperationsSorter.ALPHA)
                .showExtensions(false)
                .tagsSorter(TagsSorter.ALPHA)
                .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
                .validatorUrl(null)
                .build()
//        return UiConfiguration(
//                java.lang.Boolean.TRUE,
//                java.lang.Boolean.FALSE,
//                1,
//                1,
//                ModelRendering.MODEL,
//                java.lang.Boolean.FALSE,
//                DocExpansion.LIST,
//                java.lang.Boolean.FALSE,
//                null,
//                OperationsSorter.ALPHA,
//                java.lang.Boolean.FALSE,
//                TagsSorter.ALPHA,
//                UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS,
//                null
//        )
    }

    private fun apiInfo(): ApiInfo {
        var version = "0.0.1"
        if(build.isPresent && git.isPresent) {
            version = "${build.get().version}-${git.get().shortCommitId}-${git.get().branch}"
        }
        return ApiInfoBuilder()
                .title("Person Service API")
                .description("Persons Management")
                .version(version)
                .contact(Contact("name", "URL", "email"))
                .license("license")
                .licenseUrl("license URL")
                .termsOfServiceUrl("term of service URL")
                .build()
    }
}