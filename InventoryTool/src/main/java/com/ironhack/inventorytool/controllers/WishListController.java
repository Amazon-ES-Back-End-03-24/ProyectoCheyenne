package com.ironhack.inventorytool.controllers;

import com.ironhack.inventorytool.entities.WishList;
import com.ironhack.inventorytool.services.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishListController {

    @Autowired
    private WishListService wishListService;

    @PostMapping("/add")
    public WishList addProductToWishList(@RequestBody AddToWishListRequest request) {
        return wishListService.addProductToWishList(request.getCustomerId(), request.getProductId());
    }

    @GetMapping
    public List<WishList> getAllWishLists() {
        return wishListService.getAllWishLists();
    }

    @GetMapping("/{customerId}")
    public WishList getWishListByCustomerId(@PathVariable Long customerId) {
        return wishListService.getWishListByCustomerId(customerId);
    }
}

// Clase para recibir la solicitud
class AddToWishListRequest {
    private Long customerId;
    private Long productId;

    // Getters y Setters
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
