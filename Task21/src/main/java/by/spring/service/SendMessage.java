package by.spring.service;

public class SendMessage implements Send {
    public static final String TEXT_MESSAGE = "message text";

    @Override
    public void send(String message) {
        System.out.println("Text message: " + message);
    }
}
