package com.github.eminsit.ReadingIsGood.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CUSTOMERS")
public class Customer {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private String email;
}
