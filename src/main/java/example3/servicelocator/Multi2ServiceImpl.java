package example3.servicelocator;

public class Multi2ServiceImpl implements Service {
    @Override
    public int doSomething(int a) {
        return a + a;
    }
}
