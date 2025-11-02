package hr.fer.tel.rassus.server;

import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "hr.fer.tel.rassus.server")
public class Application implements CommandLineRunner {
    ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);





  }

  public void run(String... args) throws Exception {
        System.out.println("*****AAAAAAAAAAAAAAAAAAAAAAAA*****");

      for (String name : applicationContext.getBeanDefinitionNames()) {
          System.out.println(name + ": " + "AAAAAAAAAAAAAAAAAAAAAAAAAAAA");
      }

  }
}
