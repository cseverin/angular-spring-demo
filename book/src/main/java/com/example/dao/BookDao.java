package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.example.model.Author;
import com.example.model.Book;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
    
    @Autowired
    EntityManager em;
 
    @Autowired
    SessionFactory sessionFactory;

    public List<Book> listBooks(){
        Session session = sessionFactory.openSession();
        TypedQuery<Book> q = session.createQuery("Select b from Book b", Book.class);
        return q.getResultList(); 
        //CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        //return em.createQuery(cq).getResultList();
    }

    public List<Author> listAuthors(){
        Session session = sessionFactory.openSession();
        TypedQuery<Author> q = session.createQuery("Select a from Author a", Author.class);
        return q.getResultList(); 
    }


    public Book getBook(int id){
        Session session = sessionFactory.openSession();
        return session.get(Book.class, id);
    }
}
