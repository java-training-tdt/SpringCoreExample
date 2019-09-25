package spring.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.example.service.GreetingService;

@RestController
public class GreetingController {

    // Autowired by type
    @Autowired
    private GreetingService greetingService;


    @GetMapping("/greeting")
    public String greeting() {

        return greetingService.hello() + greetingService.goodbye();
    }
}
