package example9.profiler.app;

import java.util.List;

/**
 * Created by Mark Bramnik on 12/10/2016.
 */
public interface UserDao {
    void addUser(User user);
    void deleteUser(User user);
    List<User> getUsers();
}
