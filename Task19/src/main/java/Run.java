import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
        ShowBeans.showBean("markMore5", context);
        ShowBeans.showBean("markLess5", context);
        ShowBeans.showBean("markMax", context);
        ShowBeans.showBean("markMin", context);
    }
}
