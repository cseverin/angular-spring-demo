package com.example.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name="AUTHOR")
@ToString
@Data
public class Author {
    
    @Id
    @GeneratedValue
    private Integer id;
    private String prename;
    private String surname;

    @OneToMany(mappedBy="author")
    @JsonBackReference
    private Set<Book> books;
}
