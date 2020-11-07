package com.github.eminsit.ReadingIsGood.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "ORDERS")
public class Order {
    @Id @GeneratedValue
    private Long id;
    private Integer status;
    private Double totalAmount;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "orderId", orphanRemoval=true)
    @JsonManagedReference
    private List<OrderItem> items = new ArrayList<>( );

    public Order(Integer status, Double totalAmount) {
        this.status = status;
        this.totalAmount = totalAmount;
    }
}
