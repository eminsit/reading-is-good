package com.github.eminsit.ReadingIsGood.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "ORDER_ITEMS")
public class OrderItem {

    @Id
    @GeneratedValue
    private Long id;
    private Integer bookCount;
    private Long orderId;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "book_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Book book;

    public OrderItem(Integer bookCount) {
        this.bookCount = bookCount;
    }
}
