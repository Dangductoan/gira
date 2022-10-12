package cybersoft.javabackend.java18.gira;

import cybersoft.javabackend.java18.gira.security.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class GiraApplication {

    public static void main(String[] args) {
        SpringApplication.run(GiraApplication.class, args);
    }

}
