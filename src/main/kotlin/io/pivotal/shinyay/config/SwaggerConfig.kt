package io.pivotal.shinyay.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.swagger.web.*
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfig {

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
}