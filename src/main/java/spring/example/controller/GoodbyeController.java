package spring.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.example.service.GoodbyeService;

@RestController
public class GoodbyeController {

    private GoodbyeService goodbyeService;

    /**
     * DI by setter
     */
    @Autowired
    public void setGoodbyeService(GoodbyeService goodbyeService) {
        this.goodbyeService = goodbyeService;
    }

    @GetMapping("/goodbye")
    public String goodbye() {

        return goodbyeService.goodbye();
    }
}
