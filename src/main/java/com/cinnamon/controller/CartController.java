package com.cinnamon.controller;

import com.cinnamon.model.Cart;
import com.cinnamon.model.CartResponse;
import com.cinnamon.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping()
    public Cart persist(@RequestBody Cart cart){
        return cartService.persist(cart);
    }

    @GetMapping("/{id}")
    public CartResponse retrieveById(@PathVariable Long id){
        return  cartService.retrieveById(id);
    }
}
