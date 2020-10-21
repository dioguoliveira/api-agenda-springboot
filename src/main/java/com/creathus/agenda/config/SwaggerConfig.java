package com.creathus.agenda.config;

import static springfox.documentation.builders.PathSelectors.regex;
import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.creathus.agenda"))
                .paths(regex("/api/v1.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "Agenda API REST",
                "A API de Agenda é um pequeno desafio que recebi para o processo de seleção de desenvolvedores de software do Instituto Creathus.",
                "v1",
                "",
                new Contact("Diogo Oliveira", "",
                        "diogown3d@gmail.com"),
                "MIT License",
                "https://github.com/dioguoliveira/api-agenda-springboot/blob/main/LICENSE", new ArrayList<VendorExtension>()
        );

        return apiInfo;
    }
}
