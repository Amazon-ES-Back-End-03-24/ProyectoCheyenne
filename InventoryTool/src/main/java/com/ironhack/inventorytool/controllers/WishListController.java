package com.ironhack.inventorytool.controllers;

import com.ironhack.inventorytool.services.WishListService;
import com.ironhack.inventorytool.entities.WishList;
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

    @DeleteMapping("/remove")
    public WishList removeProductFromWishList(@RequestBody AddToWishListRequest request) {
        return wishListService.removeProductFromWishList(request.getCustomerId(), request.getProductId());
    }
}
