package pl.coderslab.beskidyenduranceproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import javax.persistence.Entity;

@SpringBootApplication
//@EntityScan(basePackages = {"pl.coderslab.beskidyenduranceproject.entity"})
public class BeskidyEnduranceProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeskidyEnduranceProjectApplication.class, args);
    }
}
