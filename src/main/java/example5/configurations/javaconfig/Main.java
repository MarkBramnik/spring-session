package example5.configurations.javaconfig;

import example5.configurations.Client;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Mark Bramnik on 21/10/2016.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ctx.getBean(Client.class).executeMyStuff();
    }
}
