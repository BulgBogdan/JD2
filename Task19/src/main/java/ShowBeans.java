import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShowBeans {

    public static void showBean(String bean, ClassPathXmlApplicationContext context) {
        Course course = context.getBean(bean, Course.class);
        System.out.println(course);
        course.getStudents().forEach(System.out::println);
        System.out.print("\n");
    }

}
