package example4.proxy.coding;

import example4.proxy.AlgorithmImpl;

/**
 * Created by Mark Bramnik on 12/10/2016.
 */
public class Main {

    public static void main(String[] args) {
        AlgorithmImpl real = new AlgorithmImpl();
        // Proxy by Interface
        System.out.println("result: " + new ProfilingProxyByInterface(real).calculate(3,5));
        // proxy by inheritance
        System.out.println("result: " + new ProfilingProxyByInheritance().calculate(3,5));

    }
}
