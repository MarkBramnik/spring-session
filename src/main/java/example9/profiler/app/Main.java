package example9.profiler.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Mark Bramnik on 12/10/2016.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/example9/profiler/spring.xml");
        ScheduledExecutorService scheduledExecutorService =  Executors.newScheduledThreadPool(3);
           scheduledExecutorService.scheduleAtFixedRate((Runnable) () -> {
                UserController controller = ctx.getBean(UserController.class);
                controller.addUser(new User("John"));
                controller.addUser(new User("Jack"));
                controller.addUser(new User("Jenny"));
                int threeUsers = controller.getAllUsers().size();

                System.out.println("I've got: " + threeUsers + " users ");
                controller.deleteUser(new User("John"));
                controller.deleteUser(new User("Jack"));
                controller.deleteUser(new User("Jenny"));


        }, 0, 5000, TimeUnit.MILLISECONDS);


    }
}
