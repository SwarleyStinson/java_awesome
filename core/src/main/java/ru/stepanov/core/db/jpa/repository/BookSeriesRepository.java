package ru.stepanov.core.db.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import ru.stepanov.core.db.jpa.domain.BookSeries;

public interface BookSeriesRepository extends CrudRepository<BookSeries, Long> {
}
