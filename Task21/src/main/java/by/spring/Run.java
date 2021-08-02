package by.spring;

import by.spring.service.Send;
import by.spring.service.SendMessage;
import org.springframework.aop.framework.ProxyFactory;

public class Run {
    private static Send target;
    private static Send proxy;
    private static ProxyFactory proxyFactory;

    public static void main(String[] args) {
        run();
        sendMessage();
        copyMessage();
    }

    private static void run() {
        target = new SendMessage();
        proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new MessageInterceptor());
        proxyFactory.setTarget(target);
        proxy = (Send) proxyFactory.getProxy();
    }

    private static void sendMessage() {
        target.send(SendMessage.TEXT_MESSAGE);
    }

    private static void copyMessage() {
        proxy.send(SendMessage.TEXT_MESSAGE);
    }
}
