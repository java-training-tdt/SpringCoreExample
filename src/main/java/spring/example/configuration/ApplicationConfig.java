package spring.example.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.example.service.BeanLifecycleService1;
import spring.example.service.BeanLifecycleService2;
import spring.example.service.BeanLifecycleService3;
import spring.example.service.FooService;

@Configuration
public class ApplicationConfig {

    @Bean
    public FooService fooService() {
        return new FooService();
    }

    @Bean(initMethod = "initBeanLifecycleService1", destroyMethod = "destroyBeanLifecycleService1")
    public BeanLifecycleService1 beanLifecycleService1() {
        return new BeanLifecycleService1();
    }

    @Bean
    public BeanLifecycleService2 beanLifecycleService2() {
        return new BeanLifecycleService2();
    }

    @Bean
    public BeanLifecycleService3 beanLifecycleService3() {
        return new BeanLifecycleService3();
    }
}
