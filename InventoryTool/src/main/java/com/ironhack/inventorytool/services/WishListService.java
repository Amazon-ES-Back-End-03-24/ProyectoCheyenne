package com.ironhack.inventorytool.services;

import com.ironhack.inventorytool.entities.Product;
import com.ironhack.inventorytool.entities.WishList;
import com.ironhack.inventorytool.repositories.ProductRepository;
import com.ironhack.inventorytool.repositories.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListService {

    @Autowired
    private WishListRepository wishListRepository;

    @Autowired
    private ProductRepository productRepository;

    public WishList addProductToWishList(Long customerId, Long productId) {

        WishList wishList = wishListRepository.findByCustomerId(customerId)
                .orElse(new WishList());


        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        wishList.getProducts().add(product);
        product.setWishListCount(product.getWishListCount() + 1);
        productRepository.save(product);

        return wishListRepository.save(wishList);
    }

    public List<WishList> getAllWishLists() {
        return wishListRepository.findAll();
    }

    public WishList getWishListByCustomerId(Long customerId) {
        return wishListRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new RuntimeException("Wish list not found"));
    }
}
