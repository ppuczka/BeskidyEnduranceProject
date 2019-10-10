package pl.coderslab.beskidyenduranceproject.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.coderslab.beskidyenduranceproject.converter.MessageConverter;
import pl.coderslab.beskidyenduranceproject.converter.MountainConverter;
import pl.coderslab.beskidyenduranceproject.converter.TownConverter;
import pl.coderslab.beskidyenduranceproject.service.StravaApiService;


@Configuration
@EntityScan(basePackages = {"pl.coderslab.beskidyenduranceproject"})
public class AppConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(getMountainConverter());
        registry.addConverter(getTownConverter());
        registry.addConverter(getMessageConverter());
    }

    @Bean
    public StravaApiService getStravaApiService() {
        return new StravaApiService();
    }

    @Bean
    public MountainConverter getMountainConverter() {
        return new MountainConverter();

    }
    @Bean
    public TownConverter getTownConverter() {
        return new TownConverter();
    }

    @Bean
    public MessageConverter getMessageConverter() {
        return new MessageConverter();
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("binding-handling/messages");
        source.setUseCodeAsDefaultMessage(true);
        return source;
    }
}
