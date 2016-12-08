package example8.bean.lifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Mark Bramnik on 15/10/2016.
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/example8/bean/lifecycle/spring.xml");
        SamplePerson samplePerson = ctx.getBean(SamplePerson.class);


    }
}
