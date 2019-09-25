package spring.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.example.repository.HelloRepository;

@Service
public class HelloService {

    private HelloRepository helloRepository;

    /**
     * DI by Constructor
     *
     */
    @Autowired
    public HelloService(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }

    public String hello() {

        return helloRepository.sayHello();
    }
}
