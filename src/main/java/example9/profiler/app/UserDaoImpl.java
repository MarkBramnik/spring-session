package example9.profiler.app;

import example9.profiler.infra.EnabledForProfiling;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * Created by Mark Bramnik on 12/10/2016.
 */
@Component
public class UserDaoImpl implements UserDao {
    private Random random = new SecureRandom();
    private List<User> users = new ArrayList<>();

    @Override
    public void addUser(User user) {
        HeavyOperationSimulator.sleep(random.nextInt(200));
        users.add(user);
    }

    @Override
    public void deleteUser(User user) {
        users.remove(user);
    }

    @Override
    @EnabledForProfiling
    public List<User> getUsers() {
        HeavyOperationSimulator.sleep(random.nextInt(2000));
        return Collections.unmodifiableList(users);
    }
}
