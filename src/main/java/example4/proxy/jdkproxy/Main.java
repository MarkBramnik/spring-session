package example4.proxy.jdkproxy;

import example4.proxy.Algorithm;
import example4.proxy.AlgorithmImpl;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Algorithm alg = (Algorithm) Proxy.newProxyInstance(
                Main.class.getClassLoader(),
                new Class[] { Algorithm.class },
                new ProfilingProxyHandler(new AlgorithmImpl()) );
        System.out.println("result: " + alg.calculate(3,5));
    }
}
