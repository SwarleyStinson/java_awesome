package ru.stepanov.core.db;

import javafx.util.Pair;
import lombok.val;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import ru.stepanov.core.db.jpa.domain.Author;
import ru.stepanov.core.db.jpa.domain.Book;
import ru.stepanov.core.db.jpa.domain.BookSeries;
import ru.stepanov.core.db.jpa.repository.AuthorRepository;
import ru.stepanov.core.db.jpa.repository.BookRepository;
import ru.stepanov.core.db.jpa.repository.BookSeriesRepository;
import wiremock.org.apache.commons.lang3.RandomStringUtils;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

@SpringBootApplication
public class DbApp {
    public static void main(String[] args) {
        SpringApplication.run(DbApp.class, args);
    }

    @Bean
    public CommandLineRunner demo(
            BookRepository bookRepo,
            AuthorRepository authorRepo,
            BookSeriesRepository seriesRepo) {
        return (args) -> {
//            generateAuthors(bookRepo, authorRepo);
//            generateBooks(bookRepo, authorRepo);
//            generateBookSeries(bookRepo, seriesRepo);

            val single = runAndProfile(() -> bookRepo.findById(20L));
            val list = runAndProfile(() -> bookRepo.findFiltered("Bob"));
            val list2 = runAndProfile(() -> bookRepo.findAll());
            System.out.println(1);
        };
    }

    public Pair<Object, Long> runAndProfile(Supplier<Object> action) {
        long startTime = System.currentTimeMillis();
        return new Pair(action.get(), System.currentTimeMillis() - startTime);
    }

    public void generateBookSeries(BookRepository bookRepo, BookSeriesRepository seriesRepo) {
        String[] names = {"Great", "Best", "Unique", "Wise", "Awesome", "Handsome", "Brave", "Strong"};
        Random random = new Random();

        bookRepo.findAll().forEach(r -> {
            String commonId = RandomStringUtils.randomAlphabetic(25);
            r.setCommonId(commonId);
            bookRepo.save(r);

            seriesRepo.save(BookSeries.builder()
                    .commonId(commonId)
                    .name(names[random.nextInt(7)] + RandomStringUtils.randomAlphabetic(4).toUpperCase())
                    .edition(Integer.valueOf(RandomStringUtils.randomNumeric(3, 5)))
                    .build());
        });
    }

    public void generateAuthors(BookRepository bookRepo, AuthorRepository authorRepo) {
        String[] names = {"Alex", "Bob", "Constantin", "Dmitry", "Eugeny", "Fedor", "George"};
        String[] nicknames = {"Wise", "Awesome", "Handsome", "Brave", "Strong"};
        String[] secondNames = {"Smith", "Johnson", "Erikson", "Mosby", "Stinson"};
        Random random = new Random();

        for (int j = 0; j < names.length; j++) {
            for (int k = 0; k < nicknames.length; k++) {
                for (int l = 0; l < secondNames.length; l++) {
                    authorRepo.save(Author.builder()
                            .fullName(names[j] + " " + nicknames[k] + " " + secondNames[l])
                            .birthDate(LocalDateTime.now()
                                    .minusYears(random.nextInt(100))
                                    .minusMonths(random.nextInt(12))
                                    .minusDays(random.nextInt(31))
                            )
                            .build());
                }
            }
        }
    }

    public void generateBooks(BookRepository bookRepo, AuthorRepository authorRepo) {
        String[] first = {"The history", "Tale", "Saga", "Poem", "Novel", "Ballad", "Epic"};
        String[] nicknames = {"Wise", "Awesome", "Handsome", "Brave", "Strong"};
        Random random = new Random();
        List<Author> authors = (List<Author>) authorRepo.findAll();

        for (int j = 0; j < first.length; j++) {
            for (int k = 0; k < nicknames.length; k++) {
                Author author = authors.get(random.nextInt(authors.size()));
                bookRepo.save(
                        Book.builder()
                                .author(author.getFullName())
                                .title(first[j] + " about " + nicknames[k] + " " + RandomStringUtils.randomAlphabetic(4))
                                .totalPages(random.nextInt(2_500))
                                .releaseDate(author.getBirthDate().plusYears(10 + random.nextInt(20)))
                                .build()
                );
            }
        }
    }


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan(new String[]{"ru.stepanov.core.db.dao"});
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
