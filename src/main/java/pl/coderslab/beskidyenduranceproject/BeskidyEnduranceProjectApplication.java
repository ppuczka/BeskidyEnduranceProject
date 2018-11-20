package pl.coderslab.beskidyenduranceproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class BeskidyEnduranceProjectApplication extends SpringBootServletInitializer {


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BeskidyEnduranceProjectApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(BeskidyEnduranceProjectApplication.class, args);
    }
}
