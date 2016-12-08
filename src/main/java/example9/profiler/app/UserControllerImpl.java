package example9.profiler.app;

import example9.profiler.infra.EnabledForProfiling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Mark Bramnik on 12/10/2016.
 */
@Component
public class UserControllerImpl implements UserController {
    private UserService service;

    @Autowired
    public UserControllerImpl(UserService service) {
        this.service = service;
    }

    @Override
    public void addUser(User user) {
        this.service.addUser(user);
    }

    @Override
    @EnabledForProfiling(flowId = "get all users")
    public List<User> getAllUsers() {
        HeavyOperationSimulator.sleep(300);
        return service.getAllUsers();
    }

    @Override
    public void deleteUser(User user) {
         service.deleteUser(user);
    }
}



