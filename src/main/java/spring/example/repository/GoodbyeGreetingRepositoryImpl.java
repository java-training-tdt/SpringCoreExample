package spring.example.repository;

import org.springframework.stereotype.Repository;

@Repository("GoodbyeGreetingRepository")
public class GoodbyeGreetingRepositoryImpl implements GreetingRepository {

    public String sayGreeting() {

        return "GREETING GOODBYE !!!";
    }
}
