package spring.example.repository;

import org.springframework.stereotype.Repository;

@Repository
public class HelloRepositoryImpl implements HelloRepository {

    public String sayHello() {

        return "HELLO !!!";
    }

    public void printHello() {

        System.out.println("HELLO !!!");
    }
}
