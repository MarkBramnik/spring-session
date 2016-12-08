package example2.di.nodi;

class Service {
    String getName() {return "john";}
}
public class Client {
    // Internal reference to the service used by this client
    private Service service;

    // Constructor
    Client() {
        // Specify a specific implementation in the constructor instead of using dependency injection
        service = new Service();
    }

    // Method within this client that uses the services
    public String greet() {
        return "Hello " + service.getName();
    }
}