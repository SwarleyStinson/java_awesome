package ru.stepanov.core.db.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import ru.stepanov.core.db.jpa.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
