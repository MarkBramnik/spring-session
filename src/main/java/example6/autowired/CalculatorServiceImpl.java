package example6.autowired;

import org.springframework.stereotype.Component;

@Component
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public int sum(int a, int b) {
        return a + b;
    }
}
