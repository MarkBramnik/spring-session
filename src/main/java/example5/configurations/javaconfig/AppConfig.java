package example5.configurations.javaconfig;

import example5.configurations.CalculatorService;
import example5.configurations.CalculatorServiceImpl;
import example5.configurations.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {
    @Bean
    CalculatorService calculator() {
        return new CalculatorServiceImpl();
    }

    @Bean
    Client client() {
        return new Client(calculator());
    }
}
