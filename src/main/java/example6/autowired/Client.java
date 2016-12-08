package example6.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Mark Bramnik on 12/10/2016.
 */
@Component
public class Client {

    @Autowired
    private CalculatorServiceImpl byClass;

    @Autowired
    private CalculatorService byInterface;

    private CalculatorService bySetter;

    @Autowired
    public void setCalculatorService(CalculatorService bySetter) {
        this.bySetter = bySetter;
    }

    public void doMyStuff() {
        System.out.println("byClass:     " + byClass);
        System.out.println("byInterface: " + byInterface);
        System.out.println("bySetter:    " + bySetter);
    }
}
