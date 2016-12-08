package example4.proxy.coding;


import example4.proxy.AlgorithmImpl;

public class ProfilingProxyByInheritance extends AlgorithmImpl {

    @Override
    public int calculate(int a, int b) {
        long start = System.currentTimeMillis();
        try {
            return super.calculate(a, b);
        }finally {
            long end = System.currentTimeMillis();
            System.out.println("Took : " + (end - start) + " ms ");
        }
    }
}
