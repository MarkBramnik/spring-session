package example3.servicelocator;

public class Main {

    public void runFlow() {
        int multiResult = ServiceLocator.getService("multi").doSomething(10);
        int powerResult = ServiceLocator.getService("power").doSomething(10);
        System.out.println("multi: "  + multiResult);
        System.out.println("power: "  + powerResult);
    }

    public static void main(String[] args) {
        new Main().runFlow();
    }
}
