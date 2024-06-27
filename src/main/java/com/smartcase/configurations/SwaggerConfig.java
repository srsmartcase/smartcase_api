package com.smartcase.configurations;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi api() {
        String[] paths = {"/**"};
        String[] excludePaths = {"/v2/**"}; // Exclude v2 endpoints
        String[] packagesToScan = {"com.smartcase.controller"}; // Your specific controller package
        return GroupedOpenApi.builder()
                .group("default")
                .packagesToScan(packagesToScan)
                .pathsToMatch(paths)
                .pathsToExclude(excludePaths)
                .build();
    }
}
