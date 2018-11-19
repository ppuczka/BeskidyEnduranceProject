package pl.coderslab.beskidyenduranceproject.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EntityScan(basePackages = {"pl.coderslab.beskidyenduranceproject"})
public class AppConfig implements WebMvcConfigurer {

}
