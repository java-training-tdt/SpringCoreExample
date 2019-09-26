package spring.example.service;

public class BeanLifecycleService1 {

    public void initBeanLifecycleService1() {
        System.out.println("BeanLifecycleService1 was initialized");
    }

    public void doStuff() {
        System.out.println("This is BeanLifecycleService1");
    }

    public void destroyBeanLifecycleService1() {
        System.out.println("BeanLifecycleService1 was destroyed");
    }
}
