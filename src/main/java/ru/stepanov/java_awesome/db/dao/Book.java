package ru.stepanov.java_awesome.db.dao;

import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Builder
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String title;
    String author;
    @Column(name = "release_date")
    LocalDateTime releaseDate;
    @Column(name = "total_pages")
    long totalPages;
}
