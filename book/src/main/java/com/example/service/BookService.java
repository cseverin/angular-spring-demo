package com.example.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.dao.BookDao;
import com.example.model.Author;
import com.example.model.Book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BookService {
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
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

    public void delete(Integer id){
        this.dao.delete(this.dao.getBook(id));
    }


    public Book insert(Book book){
        book.setId(null);
        this.dao.store(book);
        return book;
    }

    public Book update(Book book){
        Book stored = this.getBook(book.getId());
        logger.warn("title before: {}", stored.getTitle());
        stored.setTitle(book.getTitle());
        logger.warn("title after: {}", stored.getTitle());
        stored.setAuthorId(book.getAuthorId());
        this.dao.store(stored);
        return stored;
    }

}
