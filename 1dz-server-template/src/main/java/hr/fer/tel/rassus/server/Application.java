package hr.fer.tel.rassus.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

@Component
class AppStartupRunner implements CommandLineRunner {

    private final ApplicationContext applicationContext;

    public AppStartupRunner(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Application started successfully!");
        System.out.println("Beans found: " + applicationContext.getBeanDefinitionNames().length);
    }
}
