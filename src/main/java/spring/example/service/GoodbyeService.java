package spring.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.example.repository.GoodByeRepository;

@Service
public class GoodbyeService {

    private GoodByeRepository goodByeRepository;

    /**
     * DI by setter
     */
    @Autowired
    public void setGoodByeRepository(GoodByeRepository goodByeRepository) {
        this.goodByeRepository = goodByeRepository;
    }

    public String goodbye() {

        return goodByeRepository.sayGoodBye();
    }
}
