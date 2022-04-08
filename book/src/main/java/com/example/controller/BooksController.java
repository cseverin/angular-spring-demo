package com.example.controller;
import java.util.List;

import com.example.model.Book;
import com.example.model.Edit;
import com.example.service.BookService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController()
@RequestMapping("api")
public class BooksController {
    
    @Autowired 
    BookService service;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/books") 
    List<Book> listBooks(){
        logger.warn("** List books");
        return this.service.listBooks();
    }


    @GetMapping("/books/{id}")
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
 
    @PostMapping("/books")
    Edit setBook(@RequestBody Book book){
        logger.warn("** Put Book with id={}", book.getId());
        Book stored = book.getId() >=0 ? this.service.update(book): this.service.insert(book);
        Edit edit = new Edit();
        edit.setBook(stored);
        edit.setAuthors(this.service.listAuthors());
        return edit;
    }

    @DeleteMapping("/books/{id}")
    void deleteBook(@PathVariable(value="id") int id){
        logger.warn("** Delete Book with id={}", id);
        this.service.delete(id);
    }


}
