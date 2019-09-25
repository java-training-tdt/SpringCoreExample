package spring.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.example.service.GoodbyeService;

@RestController
public class GoodbyeController {

    @Autowired
    private GoodbyeService goodbyeService;

    @GetMapping("/goodbye")
    public String goodbye() {

        return goodbyeService.goodbye();
    }
}
