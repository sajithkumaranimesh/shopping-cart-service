package com.cinnamon.service.impl;

import com.cinnamon.entity.CartEntity;
import com.cinnamon.model.Cart;
import com.cinnamon.repository.CartRepository;
import com.cinnamon.service.CartService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public Cart persist(Cart cart) {
        CartEntity cartEntity = modelMapper.map(cart, CartEntity.class);
        return modelMapper.map(cartEntity, Cart.class);
    }
}
