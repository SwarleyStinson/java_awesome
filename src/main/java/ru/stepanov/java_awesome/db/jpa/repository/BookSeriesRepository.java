package ru.stepanov.java_awesome.db.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import ru.stepanov.java_awesome.db.jpa.domain.BookSeries;

public interface BookSeriesRepository extends CrudRepository<BookSeries, Long> {
}
