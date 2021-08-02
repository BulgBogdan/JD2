package by.spring;

import by.spring.service.SendMessage;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
        SendMessage sendMessage = context.getBean("sendMessage", SendMessage.class);
        Long start = System.currentTimeMillis();
        sendMessage.send();
        try {
            sendMessage.sendException();
        } catch (Exception e) {
            System.out.println("Start Exception");
        }
        Long finish = System.currentTimeMillis();
        System.out.println("Time method: " + (finish - start));
        context.close();
    }
}
