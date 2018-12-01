package pl.coderslab.beskidyenduranceproject.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.coderslab.beskidyenduranceproject.converter.MountainConverter;
import pl.coderslab.beskidyenduranceproject.converter.TownConverter;


@Configuration
@EntityScan(basePackages = {"pl.coderslab.beskidyenduranceproject"})
public class AppConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverter(getStringToIntegerConverter());
        registry.addConverter(getMountainConverter());
        registry.addConverter(getTownConverter());
    }

//    @Bean
//    public StringToIntegerConverter getStringToIntegerConverter() {
//        return new StringToIntegerConverter();
//    }

    @Bean
    public MountainConverter getMountainConverter() {
        return new MountainConverter();

    }

    @Bean
    public TownConverter getTownConverter() {
        return new TownConverter();
    }
}
