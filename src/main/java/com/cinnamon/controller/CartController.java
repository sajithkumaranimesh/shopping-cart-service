package com.cinnamon.controller;

import com.cinnamon.model.Cart;
import com.cinnamon.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("carts")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping()
    public Cart persist(@RequestBody Cart cart){
        return cartService.persist(cart);
    }
}
