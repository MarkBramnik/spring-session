package example9.profiler.app;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void deleteUser(User user);
    List<User> getAllUsers();
}
