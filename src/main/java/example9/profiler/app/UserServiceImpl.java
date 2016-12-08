package example9.profiler.app;

import example9.profiler.infra.EnabledForProfiling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Mark Bramnik on 12/10/2016.
 */

@Component
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @EnabledForProfiling(flowId = "adding user")
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }


    @Override
    @EnabledForProfiling
    public List<User> getAllUsers() {
        return userDao.getUsers();
    }
}
