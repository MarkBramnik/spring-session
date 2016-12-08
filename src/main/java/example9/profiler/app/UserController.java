package example9.profiler.app;

import java.util.List;

/**
 * Created by Mark Bramnik on 12/10/2016.
 */
public interface UserController {

    void addUser(User user);
    List<User> getAllUsers();
    void deleteUser(User user);

}
