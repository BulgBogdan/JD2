package task71;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HelloWorld {

    public HelloWorld() {
    }

    public void printHelloWorld() {
        System.out.println("Hello World");
    }

    public static void startMethodHelloWorld(Object object) {
        Class clazz = object.getClass();
        try {
            Method method = clazz.getMethod("printHelloWorld");
            method.setAccessible(true);
            method.invoke(object);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
