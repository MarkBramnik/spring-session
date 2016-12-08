package example7.prototypes.in.singletons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class PizzaSuperStarServiceThatIllustratesNaiveApproach implements PizzaService {

    @Autowired
    private Pizza pizza;


    @Override
    public Pizza preparePizza() {
        return pizza;
    }
}
