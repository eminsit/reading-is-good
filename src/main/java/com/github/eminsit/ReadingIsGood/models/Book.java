package com.github.eminsit.ReadingIsGood.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BOOKS")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @Column(name = "author_name")
    private String authorName;
    private Integer count;
    private Double price;

    public Book(String title, String authorName, Integer count, Double price) {
        this.title = title;
        this.authorName = authorName;
        this.count = count;
        this.price = price;
    }
}
