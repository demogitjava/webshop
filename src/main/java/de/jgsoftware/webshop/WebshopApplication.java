package de.jgsoftware.webshop;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author hoscho
 */

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "de.jgsoftware.landingpage.dao.interfaces.*") 
@EnableTransactionManagement
public class WebshopApplication implements i_webShop
{


 

}
