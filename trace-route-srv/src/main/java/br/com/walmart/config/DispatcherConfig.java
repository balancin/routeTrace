package br.com.walmart.config;

/**
 * Created by balancin on 8/29/14.
 */
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
//@Import({ThymeleafConfig.class})
public class DispatcherConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("dispatcher config ...");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/html/**").addResourceLocations("/html/");
        registry.addResourceHandler("/images/**").addResourceLocations("/images/");
        registry.addResourceHandler("/WEB-INF/**").addResourceLocations("/WEB-INF/");
        registry.addResourceHandler("/views/**").addResourceLocations("/views/");
    }
}