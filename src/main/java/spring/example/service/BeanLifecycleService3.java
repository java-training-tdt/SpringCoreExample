package spring.example.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanLifecycleService3 implements InitializingBean, DisposableBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("BeanLifecycleService3 was initialized");
    }

    public void doStuff() {
        System.out.println("This is BeanLifecycleService3");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("BeanLifecycleService3 was destroyed");
    }
}
