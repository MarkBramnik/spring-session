package example2.di.setter;

class Service {
    String getName() {return "john";}
}
public class Client {
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
