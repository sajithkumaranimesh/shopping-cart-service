package com.cinnamon.service;

import com.cinnamon.model.Cart;
import com.cinnamon.model.CartResponse;

public interface CartService {
    Cart persist(Cart cart);

    CartResponse retrieveById(Long id);
}
