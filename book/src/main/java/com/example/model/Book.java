package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name="BOOK")
@ToString
@Data
public class Book {
    
    @Id
    @GeneratedValue
    private Integer id = -1;
    private String title = "";

    @ManyToOne
    @JoinColumn(name="author", nullable=false, insertable = false, updatable = false)
    @JsonManagedReference
    private Author author;

    @Column(name="author")
    private int authorId;
}
