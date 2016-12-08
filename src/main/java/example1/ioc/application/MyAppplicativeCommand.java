package example1.ioc.application;

import example1.ioc.framework.Command;

import java.util.Date;

public class MyAppplicativeCommand implements Command {

    public void execute() {
        System.out.println("Hello, I'm an applicative command: " + new Date());
    }
}
