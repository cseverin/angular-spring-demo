package com.example.model;

import java.util.List;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Edit {
    
    Book book;
    List<Author> authors;


    public void setBook(Book book) {
        this.book = book;
    }

    public void setAuthors(List<Author> authors){
        this.authors = authors;
    }
}
