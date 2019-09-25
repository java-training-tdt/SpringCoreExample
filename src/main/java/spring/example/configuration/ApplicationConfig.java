package spring.example.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.example.service.FooService;

@Configuration
public class ApplicationConfig {

    @Bean
    public FooService fooService() {
        return new FooService();
    }
}
