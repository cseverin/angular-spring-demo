package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.example.model.Author;
import com.example.model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
    
    @Autowired
    EntityManager em;
 

    public List<Book> listBooks(){
        TypedQuery<Book> q = em.createQuery("Select b from Book b", Book.class);
        return q.getResultList(); 
        //CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        //return em.createQuery(cq).getResultList();
    }

    public List<Author> listAuthors(){
        TypedQuery<Author> q = em.createQuery("Select a from Author a", Author.class);
        return q.getResultList(); 
    }


    public Book getBook(int id){
        Book book = em.find(Book.class, id);
        return book;
    }

    public void store(Book book){
        em.merge(book);
    }

    public void delete(Book book){
        this.em.remove(book);
    }
}
