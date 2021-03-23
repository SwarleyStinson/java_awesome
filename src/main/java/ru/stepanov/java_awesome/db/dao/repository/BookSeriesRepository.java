package ru.stepanov.java_awesome.db.dao.repository;

import org.springframework.data.repository.CrudRepository;
import ru.stepanov.java_awesome.db.dao.domain.BookSeries;

public interface BookSeriesRepository extends CrudRepository<BookSeries, Long> {
}
