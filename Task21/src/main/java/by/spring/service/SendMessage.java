package by.spring.service;

import org.springframework.stereotype.Service;

@Service
public class SendMessage {

    private final String message = "Text";

    public void send() {
        System.out.println("Text message: " + message);
    }

    public void sendException() throws Exception {
        System.out.println("Exception");
        throw new Exception();
    }
}
