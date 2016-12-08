package example3.servicelocator;

public class ServiceLocator {
    private static Service multi2 = new Multi2ServiceImpl();
    private static Service pow2   = new Pow2ServiceImpl();
        public static Service getService(String qualifier) {
            if("multi".equals(qualifier)) {
                return multi2;
            }
            else if("power".equals(qualifier)) {
                return pow2;
            }
            else throw new RuntimeException("No registered services found");

        }
}
