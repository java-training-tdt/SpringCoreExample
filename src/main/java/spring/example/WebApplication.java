package spring.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.example.configuration.ApplicationConfig;
import spring.example.repository.HelloRepository;
import spring.example.repository.HelloRepositoryImpl;
import spring.example.service.FooService;

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
        FooService fooServiceByName = (FooService)context.getBean("fooService");
        fooServiceByName.doBeanByName();

        // get bean by interface (1 interface has 1 implement)
        HelloRepository helloRepository = context.getBean(HelloRepository.class);
        helloRepository.printHello();

        // get bean by interface (1 interface has many implements)

        context.close();
    }
}
