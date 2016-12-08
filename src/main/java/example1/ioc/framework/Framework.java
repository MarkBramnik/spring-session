package example1.ioc.framework;

import java.io.*;
import java.util.stream.IntStream;

public class Framework {

    public static void main(String [] args) throws InterruptedException {
        Command command  = scanTheClassPathAndFindTheImplemenationOfCommandInterface();
        IntStream.rangeClosed(1,5).forEach(i -> {
            System.out.println("framework calls the command: " + i);
            command.execute();
        });


    }

    private static Command scanTheClassPathAndFindTheImplemenationOfCommandInterface() {
        InputStream is = Framework.class.getResourceAsStream("/example1/ioc/application/command.implementation");
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        try {
            String line = reader.readLine();
            return (Command) Class.forName(line).newInstance();
        } catch (IOException | IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


}
