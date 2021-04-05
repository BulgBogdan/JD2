import task70.Man;
import task71.HelloWorld;
import task72.ClassWithAnnotation;

public class Runner {

    public static void main(String[] args) {
        // task 70
        Man.getInformation(new Man());
        System.out.println("---------------------------------");
        // task 71
        HelloWorld.startMethodHelloWorld(new HelloWorld());
        System.out.println("---------------------------------");
        // task 72
        ClassWithAnnotation.checkMethods(new ClassWithAnnotation());
    }
}