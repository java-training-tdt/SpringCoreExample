package spring.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import spring.example.repository.GreetingRepository;

@Service
public class GreetingService {

    @Autowired
    @Qualifier("HelloGreetingRepository")
    private GreetingRepository helloGreetingRepository;

    @Autowired
    @Qualifier("GoodbyeGreetingRepository")
    private GreetingRepository goodbyeGreetingRepository;

    public String hello() {

        return helloGreetingRepository.sayGreeting();
    }

    public String goodbye() {

        return goodbyeGreetingRepository.sayGreeting();
    }
}
