package example4.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Mark Bramnik on 12/10/2016.
 */
public class ProfilingProxyHandler implements InvocationHandler {
    private Object obj;

    public ProfilingProxyHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        try {
           return method.invoke(obj, args);
        }finally {
            long end = System.currentTimeMillis();
            System.out.println("Took : " + (end - start) + " ms ");
        }
    }
}
