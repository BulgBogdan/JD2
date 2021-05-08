package Person_Address.connector;

import java.util.ResourceBundle;

public interface Connector {

    String URL = ResourceBundle.getBundle("database").getString("url");
    String USER = ResourceBundle.getBundle("database").getString("user");
    String PASSWORD = ResourceBundle.getBundle("database").getString("password");

}