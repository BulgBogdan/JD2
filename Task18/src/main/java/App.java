import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");
        WalkBean walkBean = context.getBean("walk", WalkBean.class);
        walkBean.walk();
    }
}
