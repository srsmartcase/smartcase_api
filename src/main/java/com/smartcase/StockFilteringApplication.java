package com.smartcase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Value;

@SpringBootApplication
public class StockFilteringApplication {

    @Value("${server.port}")
    private String serverPort;

    @Value("${server.servlet.context-path:}")
    private String contextPath;

    public static void main(String[] args) {
        // Start the Spring Boot application and get the application context
        var context = SpringApplication.run(StockFilteringApplication.class, args);

        // Retrieve the Environment instance from the application context
        Environment env = context.getBean(Environment.class);

        // Get server port and context path from application.properties
        String port = env.getProperty("server.port");
        String contextPath = env.getProperty("server.servlet.context-path");

        // Construct Swagger UI URL
        String swaggerUrl = "http://localhost:" + port;
        if (contextPath != null && !contextPath.isEmpty()) {
            swaggerUrl += contextPath;
        }
        swaggerUrl += "/swagger-ui/index.html";

        // Log the Swagger UI URL
        System.out.println("Swagger UI is available at: " + swaggerUrl);
    }
}
