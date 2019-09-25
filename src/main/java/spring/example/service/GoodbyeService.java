package spring.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.example.repository.GoodByeRepository;

@Service
public class GoodbyeService {

    /**
     * DI by setter
     */
    @Autowired
    private GoodByeRepository goodByeRepository;

    public String goodbye() {

        return goodByeRepository.sayGoodBye();
    }
}
