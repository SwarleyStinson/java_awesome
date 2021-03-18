package ru.stepanov.java_awesome.db;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import ru.stepanov.java_awesome.db.dao.Book;
import ru.stepanov.java_awesome.db.dao.BookRepository;

import javax.sql.DataSource;
import java.time.LocalDateTime;

@EnableJpaRepositories(basePackages = "ru.stepanov.java_awesome.db.dao")
@EntityScan(basePackages = "ru.stepanov.java_awesome.db")
@SpringBootApplication
public class DbApp {
    public static void main(String[] args) {
        SpringApplication.run(DbApp.class, args);
    }

    @Bean
    public CommandLineRunner demo(BookRepository repository) {
        return (args) -> {
            System.out.println(1);
            repository.save(
                    Book.builder()
                            .author("Alex Pushkin")
                            .title("Onegin")
                            .totalPages(100)
                            .releaseDate(LocalDateTime.now())
                            .build()
            );

            System.out.println(2);
        };
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan(new String[]{"ru.stepanov.java_awesome.db.dao"});
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return em;
    }

    @Bean
    public DataSource dataSource(Environment env) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        return dataSource;
    }
}
