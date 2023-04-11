package de.jgsoftware.webshop.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author hoscho
 */

@Configuration
public class MvcConfig implements WebMvcConfigurer
{

    @Autowired
    public AppConfigLocale appConfigLocale;


    public void addViewControllers(ViewControllerRegistry registry)
    {



        registry.addViewController("/").setViewName("index");
        registry.addViewController("/admin").setViewName("admin");
        registry.addViewController("/userprofile").setViewName("userprofile");
        registry.addViewController("/about").setViewName("about");
        registry.addViewController("/userindexnotloggedin").setViewName("usernotloggedin");
    }

    public AppConfigLocale getAppConfigLocale() {
        return appConfigLocale;
    }
    public void setAppConfigLocale(AppConfigLocale appConfigLocale) {
        this.appConfigLocale = appConfigLocale;
    }
}