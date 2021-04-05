package task72;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Objects;

public class ClassWithAnnotation {

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";

    @AcademyInfo
    public void methodWithAnnotation() {
        System.out.println("method with annotation");
    }

    public void methodWithoutAnnotation() {
        System.out.println("method without annotation");
    }

    public static void checkMethods(Object object) {
        Class clazz = object.getClass();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            Annotation annotation = method.getAnnotation(AcademyInfo.class);
            if (Objects.nonNull(annotation)) {
                System.out.println(ANSI_GREEN + method.getName() + " is have annotation".toUpperCase());
            } else {
                System.out.println(ANSI_RED + method.getName() + " isn't have annotation");
            }
        }
    }
}