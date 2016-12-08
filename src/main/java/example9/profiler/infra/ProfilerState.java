package example9.profiler.infra;

/**
 * Created by Mark Bramnik on 21/10/2016.
 */
public interface ProfilerState {
    boolean isProfilingEnabled(String flowId);
    void addFlowInformation(String flowId);

}
