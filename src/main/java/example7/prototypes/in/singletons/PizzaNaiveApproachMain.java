package example7.prototypes.in.singletons;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;

/**
 * Created by Mark Bramnik on 22/10/2016.
 */

public class PizzaNaiveApproachMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("example7/prototypes/in/singletons/spring-pizza-naive-approach.xml");
        PizzaService pizzaService = ctx.getBean(PizzaService.class);
        range(0,5).forEach(
                i -> System.out.println(pizzaService.preparePizza())
        );
    }
}
