package example6.autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Mark Bramnik on 12/10/2016.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/example6/autowired/spring.xml");
        Client client= ctx.getBean(Client.class);
        client.doMyStuff();
    }
}

