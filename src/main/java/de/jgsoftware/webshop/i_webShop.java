package de.jgsoftware.webshop;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
//import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
public interface i_webShop
{



    static void main(String[] args)
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

        SpringApplication.run(WebshopApplication.class, args);
    }

}
