package de.jgsoftware.webshop;

import org.h2.tools.Server;

import java.sql.SQLException;

import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;


@SpringBootApplication
public class WebShop
{





        public WebShop()
        {

            startH2Server();
          }

        public static void main(String[] args)
        {

            SpringApplication.run(WebShop.class, args);
        }


        // start h2 database server
        private static void startH2Server()
        {
            try
            {
                Server h2Server = Server.createTcpServer().start();
                if (h2Server.isRunning(true))
                {
                    System.out.print("H2 server was started and is running." + "\n");
                } else
                {
                    h2Server = Server.createTcpServer().start();
                    throw new RuntimeException("Could not start H2 server." + "\n");
                }
            } catch (SQLException e) {
                throw new RuntimeException("Failed to start H2 server: " + e + "\n");
            }

        }



        // second jdbc session to save fibu data  NOT OVER JDBC TEMPLATE
        @Bean
        @Primary
        @ConfigurationProperties(prefix="spring.datasource")
        public DataSource datasource()
        {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            /*
            dataSource.setDriverClassName("org.h2.Driver");
            dataSource.setUrl("jdbc:h2:tcp://localhost:9092/~/shopdb");
            dataSource.setUsername("admin");
            dataSource.setPassword("jj78mvpr52k1");

            */
            return dataSource;
        }

        @Bean
        public EntityManagerFactory entityManagerFactory(DataSource dataSource)
        {

            HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
            vendorAdapter.setDatabase(Database.H2);
            LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

            factory.setJpaVendorAdapter(vendorAdapter);
            factory.setPackagesToScan("de.jgsoftware.webshop.model");
            factory.setDataSource(dataSource);
            factory.afterPropertiesSet();
            return factory.getObject();
        }

}
