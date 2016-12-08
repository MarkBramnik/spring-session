package example4.proxy.coding;

import example4.proxy.Algorithm;

public class ProfilingProxyByInterface implements Algorithm {
    private Algorithm real;

    public ProfilingProxyByInterface(Algorithm real) {
        this.real = real;
    }

    @Override
    public int calculate(int a, int b) {
        long start = System.currentTimeMillis();
        try {
            return real.calculate(a, b);
        }finally {
            long end = System.currentTimeMillis();
            System.out.println("Took : " + (end - start) + " ms ");
        }

    }
}
