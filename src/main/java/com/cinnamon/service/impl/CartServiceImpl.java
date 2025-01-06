package com.cinnamon.service.impl;

import com.cinnamon.entity.CartEntity;
import com.cinnamon.model.Cart;
import com.cinnamon.model.CartResponse;
import com.cinnamon.model.Product;
import com.cinnamon.repository.CartRepository;
import com.cinnamon.service.CartService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    private final RestTemplate restTemplate;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public Cart persist(Cart cart) {
        CartEntity cartEntity = modelMapper.map(cart, CartEntity.class);
        CartEntity saved = cartRepository.save(cartEntity);
        return modelMapper.map(saved, Cart.class);
    }

    @Override
    public CartResponse retrieveById(Long id) {
        Optional<CartEntity> cartEntity = cartRepository.findById(id);
        if (cartEntity.isPresent()){
            Product product = restTemplate.getForObject("http://CATALOG-MANAGEMENT-SERVICE/products/" + cartEntity.get().getProductId(), Product.class);
            return new CartResponse(
                    cartEntity.get().getId(),
                    cartEntity.get().getUserId(),
                    product,
                    cartEntity.get().getQuantity()
            );
        }
        return null;
    }
}
