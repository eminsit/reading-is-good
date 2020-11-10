package com.github.eminsit.ReadingIsGood.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderView {
    private Long customerId;
    private List<OrderItemView> items;
}
