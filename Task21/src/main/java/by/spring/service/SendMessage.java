package by.spring.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendMessage {

    private String message;

    public void send() {
        System.out.println("Text message: " + message);
    }

    public void sendException() throws Exception {
        System.out.println("Exception");
        throw new Exception();
    }
}
