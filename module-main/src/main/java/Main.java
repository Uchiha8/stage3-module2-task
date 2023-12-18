import com.mjc.school.controller.impl.NewsController;
import config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        NewsController newsController = applicationContext.getBean(NewsController.class);

    }
}
