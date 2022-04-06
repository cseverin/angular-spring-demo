package com.example.service;

import java.util.List;

import com.example.dao.BookDao;
import com.example.model.Author;
import com.example.model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    
    @Autowired
    BookDao dao;

    public List<Book> listBooks(){
        return this.dao.listBooks();
    }

    public List<Author> listAuthors(){
        return this.dao.listAuthors();
    }

    public Book getBook(int id){
        return dao.getBook(id);
    }


}
