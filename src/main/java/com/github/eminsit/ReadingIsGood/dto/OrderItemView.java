package com.github.eminsit.ReadingIsGood.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderItemView {
    private Long bookId;
    private Integer count;
}
