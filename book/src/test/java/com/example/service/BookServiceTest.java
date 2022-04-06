package com.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.example.model.Book;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Sql({"/import.sql"})
public class BookServiceTest {
 
    @Autowired
    BookService service;

    @Test
    public void listBooks(){
        List<Book> result = service.listBooks();
        assertEquals(3, result.size());
    }

}
