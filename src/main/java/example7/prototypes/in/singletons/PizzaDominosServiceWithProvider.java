package example7.prototypes.in.singletons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Provider;

/**
 * Created by Mark Bramnik on 22/10/2016.
 */
@Component
public class PizzaDominosServiceWithProvider implements PizzaService{
    @Autowired
    // note, there is a provider instance here
    private Provider<Pizza> pizzaProvider;

    @Override
    public Pizza preparePizza() {
        return pizzaProvider.get();
    }
}
