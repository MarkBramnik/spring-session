package example7.prototypes.in.singletons;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Mark Bramnik on 22/10/2016.
 */
public class PizzaDonPerdoServiceWithProxyMode implements PizzaService {
    @Autowired
    private Pizza pizza;

    @Override
    public Pizza preparePizza() {
        return pizza;
    }
}
