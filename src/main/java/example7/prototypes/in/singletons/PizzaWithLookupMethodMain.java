package example7.prototypes.in.singletons;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;


public class PizzaWithLookupMethodMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("example7/prototypes/in/singletons/spring-pizza-with-lookup-method.xml");
        PizzaService pizzaService = ctx.getBean(PizzaService.class);
        System.out.println("------------------------");
        System.out.println("pizza service class: " + pizzaService.getClass().getName());
        System.out.println();
        System.out.println();
        range(0,5).forEach(
                i -> System.out.println(pizzaService.preparePizza())
        );
        System.out.println("The pizza class: " + pizzaService.preparePizza().getClass().getName());
    }
}
