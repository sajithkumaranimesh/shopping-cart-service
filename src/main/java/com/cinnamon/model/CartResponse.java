package com.cinnamon.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class CartResponse {
    private Long id;
    private Long userId;
    private Product product;
    private Integer quantity;
}
