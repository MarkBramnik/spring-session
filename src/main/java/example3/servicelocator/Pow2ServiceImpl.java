package example3.servicelocator;

public class Pow2ServiceImpl implements Service {
    @Override
    public int doSomething(int a) {
        return a * a;
    }
}
