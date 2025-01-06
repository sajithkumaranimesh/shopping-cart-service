package com.cinnamon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Table(name = "carts")
public class Cart {
    private Long id;
    private Long userId;
    private Long productId;
    private Integer quantity;
}