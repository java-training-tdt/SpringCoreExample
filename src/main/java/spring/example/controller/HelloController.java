package spring.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.example.service.HelloService;

@RestController
public class HelloController {

    private HelloService helloService;

    /**
     * DI by Constructor
     *
     */
    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String hello() {

        return helloService.hello();
    }
}
