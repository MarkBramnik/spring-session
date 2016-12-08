package example4.proxy.cglib;

import example4.proxy.Algorithm;
import example4.proxy.AlgorithmImpl;
import net.sf.cglib.proxy.Enhancer;

/**
 * Created by Mark Bramnik on 12/10/2016.
 */
public class Main {
    public static void main(String[] args) {
        Algorithm alg = new AlgorithmImpl();
        Enhancer e = new Enhancer();
        e.setSuperclass(AlgorithmImpl.class);
        e.setCallback(new ProfilingInterceptor(alg));
        Algorithm proxy = (Algorithm) e.create();
        System.out.println("result: " + proxy.calculate(3,5));
    }
}
