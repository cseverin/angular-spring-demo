package com.example.controller;
import java.util.List;

import com.example.model.Book;
import com.example.model.Edit;
import com.example.service.BookService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController()
@RequestMapping("api/books")
public class BooksController {
    
    @Autowired 
    BookService service;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/list") 
    List<Book> listBooks(){
        logger.warn("** List books");
        return this.service.listBooks();
    }


    @GetMapping("/get/{id}")
    Edit getBook(@PathVariable(value="id") int id){
        logger.warn("** Get Book with id={}", id);
        Edit edit = new Edit();
        if (id < 0){
            edit.setBook(new Book());
        }else{
            edit.setBook(this.service.getBook(id));
        }
        edit.setAuthors(this.service.listAuthors());
        return edit;
    }

}
