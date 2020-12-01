package de.jgsoftware.webshop.config;



import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer
{

    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/").setViewName("index");

        registry.addViewController("/en/").setViewName("index");
        registry.addViewController("/es/").setViewName("index");
        registry.addViewController("/fr/").setViewName("index");
        registry.addViewController("/it/").setViewName("index");
        registry.addViewController("/tr/").setViewName("index");


        registry.addViewController("/login").setViewName("login");
    }

}