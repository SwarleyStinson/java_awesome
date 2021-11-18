package ru.stepanov.webapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookReq {
    String name;
    String author;
    String exist;

    public static BookReq create(){
        return new BookReq("Lord of the Rings","J.R.R.Tolkin","");
    }
}
