package example7.prototypes.in.singletons;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Mark Bramnik on 21/10/2016.
 */

@Component
@Scope("prototype")
public class Pizza {
    private int currentPizzaNumber;
    private static int pizzaCount = 0;

    public Pizza() {
        currentPizzaNumber = pizzaCount;
        pizzaCount++;
    }

    @Override
    public String toString() {
        return "Pizza # " + currentPizzaNumber;
    }
}
