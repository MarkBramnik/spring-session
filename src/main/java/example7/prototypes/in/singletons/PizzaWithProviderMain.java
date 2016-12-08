package example7.prototypes.in.singletons;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import static java.util.stream.IntStream.*;

public class PizzaWithProviderMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("example7/prototypes/in/singletons/spring-pizza-with-provider.xml");
        PizzaService pizzaService = ctx.getBean(PizzaService.class);
        System.out.println("------------------------");
        System.out.println("pizza service class: " + pizzaService.getClass().getName());
        System.out.println();
        System.out.println();
        range(0,5).forEach(i ->
                System.out.println(pizzaService.preparePizza())
        );
    }
}
