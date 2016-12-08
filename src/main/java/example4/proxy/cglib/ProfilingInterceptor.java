package example4.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Mark Bramnik on 12/10/2016.
 */
public class ProfilingInterceptor implements MethodInterceptor {
    private Object real;
    public ProfilingInterceptor(Object real) {
        this.real = real;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] arguments, MethodProxy methodProxy) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            return method.invoke(real, arguments);
        }finally {
            long end = System.currentTimeMillis();
            System.out.println("Took : " + (end - start) + " ms ");
        }
    }
}
