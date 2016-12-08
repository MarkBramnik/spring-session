package example9.profiler.infra;

import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedResource;

import java.util.*;
import java.util.function.Function;

/**
 * Created by Mark Bramnik on 21/10/2016.
 */

@ManagedResource(objectName = "SPRINGSESSION:name=SuperProfiler", description = "Flow based profiler")
public class ProfilerStateImpl implements ProfilerState {
    private Map<String, Boolean> availableFlows = new HashMap<>();

    private <T> T applyIfRegistered(String flowId, Function<String, T> function) {
        if(!availableFlows.containsKey(flowId)) {
            throw new RuntimeException("The supplied flow id is not available");
        }
        else {
           return function.apply(flowId);
        }
    }
    @Override
    public boolean isProfilingEnabled(String flowId) {
        return applyIfRegistered(flowId, flowId1 -> availableFlows.getOrDefault(flowId1, Boolean.FALSE));
    }

    @Override
    public void addFlowInformation(String flowId) {
        availableFlows.put(flowId, Boolean.FALSE);
    }

    @ManagedOperation(description = "Enable profiling for flow with id")
    @ManagedOperationParameter(name = "flowId", description = "flow id")
    public void enableProfilingFor(String flowId) {
        applyIfRegistered(flowId, (Function<String, Void>) flowId1 -> {
            availableFlows.put(flowId1, Boolean.TRUE);
            return null;
        });
    }

    @ManagedOperation(description = "Disable profiling for flow with id")
    @ManagedOperationParameter(name = "flowId", description = "flow id")
    public void disableProfilingFor(String flowId) {
        applyIfRegistered(flowId, (Function<String, Void>) flowId1 -> {
            availableFlows.put(flowId1, Boolean.FALSE);
            return null;
        });
    }

    @ManagedOperation(description = "Shows a list of registered flows enabled for profiling")
    public List<String> getRegisteredFlows() {
        return new ArrayList<>(availableFlows.keySet());
    }
}
