package example5.configurations;


import java.util.stream.IntStream;

public class Client {
    private CalculatorService calculatorService;

    public Client(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public void executeMyStuff() {
        IntStream.range(0,10).forEach(i -> System.out.println("i : " + i + " ==> " + calculatorService.sum(i, i)));
    }
}
