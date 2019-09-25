package spring.example.repository;

import org.springframework.stereotype.Repository;

@Repository("HelloGreetingRepository")
public class HelloGreetingRepositoryImpl implements GreetingRepository {

    public String sayGreeting() {

        return "GREETING HELLO !!!";
    }
}
