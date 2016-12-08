package example5.configurations.xmlconfig;

import example5.configurations.Client;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/example5/xmlconfig/spring.xml");
        Client client = ctx.getBean(Client.class);
        client.executeMyStuff();
    }
}
