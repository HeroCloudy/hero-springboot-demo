package com.yygnb.demo.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Title: com.yygnb.demo.config.SpringDocConfig
 * @Description: <h1></h1>
 * @Date: 2022/7/29 00:21
 * @Author dscloudy 小云哥
 * @Version v1.0
 * @Since JDK 1.8
 * Date     UpdateBy        Description
 * 2022/7/29 00:21   dscloudy    Create File.
 */
@RequiredArgsConstructor
@Configuration
public class SpringDocConfig {

    private final DocInfo docInfo;

    @Bean
    public OpenAPI heroOpenAPI() {
        return new OpenAPI()
                .info(new Info().title(docInfo.getTitle())
                        .description(docInfo.getDescription())
                        .version(docInfo.getVersion()))
                .externalDocs(new ExternalDocumentation().description(docInfo.getWebsiteName())
                        .url(docInfo.getWebsiteUrl()));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group(docInfo.getTitle())
                .pathsToMatch("/**")
                .build();
    }
}
