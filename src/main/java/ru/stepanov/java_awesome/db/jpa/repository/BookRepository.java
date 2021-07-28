package ru.stepanov.java_awesome.db.jpa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.stepanov.java_awesome.db.jpa.domain.Book;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    @Query(
            value = "SELECT * FROM book" +
                    " WHERE author like CONCAT('%', CAST(:author as text), '%')",
            nativeQuery = true
    )
    List<Book> findFiltered(@Param("author") String author);

}
