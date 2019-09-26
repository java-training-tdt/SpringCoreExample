package spring.example.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class BeanLifecycleService2 {

    @PostConstruct
    public void initBeanLifecycleService2() {
        System.out.println("BeanLifecycleService2 was initialized");
    }

    public void doStuff() {
        System.out.println("This is BeanLifecycleService2");
    }

    @PreDestroy
    public void destroyBeanLifecycleService2() {
        System.out.println("BeanLifecycleService2 was destroyed");
    }
}
