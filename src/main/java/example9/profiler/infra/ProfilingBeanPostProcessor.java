package example9.profiler.infra;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mark Bramnik on 12/10/2016.
 */
public class ProfilingBeanPostProcessor implements BeanPostProcessor {
    private ProfilerState profilerState;

    public ProfilingBeanPostProcessor(ProfilerState profilerState) {
        this.profilerState = profilerState;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Method[] methods = bean.getClass().getMethods();
        List<Method> annotatedMethods = Arrays.stream(methods)
              .filter(method -> method.isAnnotationPresent(EnabledForProfiling.class))
              .collect(Collectors.toList());


        if(annotatedMethods.isEmpty()) {
            return bean;
        }
        else {
            annotatedMethods.forEach(method -> {
                EnabledForProfiling annotation  =  method.getAnnotation(EnabledForProfiling.class);
                if(annotation.flowId().length() > 0) {
                    profilerState.addFlowInformation(annotation.flowId());
                }
            });

            return Proxy.newProxyInstance(getClass().getClassLoader(), bean.getClass().getInterfaces(), new RealProfilerProxyHandler(bean, profilerState));
        }
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
