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


    public static void main(String[] args)
    {



        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Europe/Berlin"));
        //ZonedDateTime now = ZonedDateTime.now();

        // 1. ZonedDateTime to TimeStamp
        Timestamp timestamp = Timestamp.valueOf(now.toLocalDateTime());

        // 2. ZonedDateTime to TimeStamp , no different
        Timestamp timestamp2 = Timestamp.from(now.toInstant());

        System.out.println("TimeZone ->" + now + "\n" + "--------------" + "\n");
        System.out.println("TimeZone location time ->" + timestamp + "\n" + "--------------" + "\n");
        System.out.println("set TimeZone to -> " + timestamp2 + "\n" + "--------------" + "\n");




        String operationsytem = System.getProperty("os.name").toLowerCase();
        if (operationsytem.contains("win")){
            //Betriebssystem = Windows
            operationsytem = "Windows";

        }
        else if (operationsytem.contains("osx")){
            //Betriebssystem = OSX von Apple
            operationsytem = "OSX Apple";
        }
        else if (operationsytem.contains("nix") || operationsytem.contains("aix") || operationsytem.contains("nux")){
            //Betriebssystem = Unix bzw. Linux basiert
            operationsytem = "unix-linux";
        }
        System.out.print(operationsytem + "\n");

        SpringApplicationBuilder builder = new SpringApplicationBuilder(WebshopApplication.class);
        builder
                // none
                // reactive
                // servlet
                .web(WebApplicationType.SERVLET)
               .headless(true).run();




        //SpringApplication.run(WebshopApplication.class, args);
    }


}
