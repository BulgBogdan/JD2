package by.spring.aspect;

public class Aspect {
    public void before() {
        System.out.println("Before method SEND");
    }

    public void after() {
        System.out.println("After method SEND");
    }

    public void throwException() {
        System.out.println("start Exception");
    }
}
