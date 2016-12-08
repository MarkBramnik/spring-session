package example2.di.interf;
class Service {
    String getName() {return "john";}
}
interface ServiceInjectable {
     void setService(Service service);
}

public class Client implements ServiceInjectable {
    // Internal reference to the service used by this client
    private Service service;

    // Set the service, will be called by DI
    public void setService(Service service) {
        this.service = service;
    }

    // Method within this client that uses the services
    public String greet() {
        return "Hello " + service.getName();
    }
}
