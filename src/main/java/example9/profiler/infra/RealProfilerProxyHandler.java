package example9.profiler.infra;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class RealProfilerProxyHandler implements InvocationHandler {
    private static ThreadLocal<String> currentFlows = new ThreadLocal<>();

    private ProfilerState state;
    private Object realImplementation;
    public RealProfilerProxyHandler(Object obj, ProfilerState state) {
        this.realImplementation = obj;
        this.state = state;
    }

    private String handleFlow(EnabledForProfiling enabledForProfiling) {
        String flowId = enabledForProfiling.flowId();
        if(flowId != null && flowId.length() > 0) {
            currentFlows.set(flowId);
        }
        String currentFlow = currentFlows.get();
        if(currentFlow == null) {
            currentFlow = "N/A flow";
        }
        return currentFlow;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object localObj = realImplementation;
        try {
            Method realObjMethod = localObj.getClass().getMethod(method.getName(), method.getParameterTypes());
            if(realObjMethod.isAnnotationPresent(EnabledForProfiling.class)) {
                String flow = handleFlow(realObjMethod.getAnnotation(EnabledForProfiling.class));
                if(state.isProfilingEnabled(flow)) {
                    long start = System.currentTimeMillis();
                    try {
                        return method.invoke(localObj, args);
                    } finally {
                        long end = System.currentTimeMillis();
                        System.out.println("Profiler: [took: " + (end - start) + " ms ] flow [ " + flow + " ] [ class : " + realImplementation.getClass().getSimpleName() + "] method [ " + method.getName() + " ]");
                    }
                }else {
                    return method.invoke(localObj, args);
                }

            }
            else {
                return method.invoke(localObj, args);
            }

        }catch(NoSuchMethodException | SecurityException ex) {
            return method.invoke(localObj, args);
        }


    }
}
