package spring.example.repository;

import org.springframework.stereotype.Repository;

@Repository
public class GoodByeRepositoryImpl implements GoodByeRepository {

    public String sayGoodBye() {

        return "GOODBYE !!!";
    }
}
