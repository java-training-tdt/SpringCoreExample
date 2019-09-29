package spring.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.example.configuration.ApplicationConfig;
import spring.example.repository.HelloRepository;
import spring.example.repository.HelloRepositoryImpl;
import spring.example.service.BeanLifecycleService1;
import spring.example.service.BeanLifecycleService2;
import spring.example.service.BeanLifecycleService3;
import spring.example.service.FooService;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ApplicationConfig.class);

        // get bean by class
        FooService fooServiceByClass = context.getBean(FooService.class);
        fooServiceByClass.doBeanByClass();

        // get bean by name
        FooService fooServiceByName =
                (FooService)context.getBean("fooService");
        fooServiceByName.doBeanByName();

        // Bean Lifecycle by initMethod & destroyMethod
        BeanLifecycleService1 beanLifecycleService1 =
                context.getBean(BeanLifecycleService1.class);
        beanLifecycleService1.doStuff();

        // Bean Lifecycle by @PostConstruct & @PreDestroy
        BeanLifecycleService2 beanLifecycleService2 =
                context.getBean(BeanLifecycleService2.class);
        beanLifecycleService2.doStuff();

        // Bean Lifecycle by implement InitializingBean & DisposableBean
        BeanLifecycleService3 beanLifecycleService3 =
                context.getBean(BeanLifecycleService3.class);
        beanLifecycleService3.doStuff();

        context.close();

    }
}
