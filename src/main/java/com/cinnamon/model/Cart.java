package com.cinnamon.model;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Cart {
    private Long id;
    private Long userId;
    private Long productId;
    private Integer quantity;
}