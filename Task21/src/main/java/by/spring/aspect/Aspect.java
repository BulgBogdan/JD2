package by.spring.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@org.aspectj.lang.annotation.Aspect
@Component
public class Aspect {

    @Before("execution(* by.spring.service.SendMessage.send())")
    public void before() {
        System.out.println("Before method SEND");
    }

    @After("execution(* by.spring.service.SendMessage.send())")
    public void after() {
        System.out.println("After method SEND");
    }

    @AfterThrowing("execution(* by.spring.service..SendMessage.sendException())")
    public void throwException() {
        System.out.println("start Exception");
    }
}
