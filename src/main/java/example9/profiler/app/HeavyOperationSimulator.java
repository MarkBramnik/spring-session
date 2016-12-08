package example9.profiler.app;

/**
 * Created by Mark Bramnik on 21/10/2016.
 */
public class HeavyOperationSimulator {
   public static void sleep(int millis) {
       try {
           Thread.sleep(millis);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
   }

}
