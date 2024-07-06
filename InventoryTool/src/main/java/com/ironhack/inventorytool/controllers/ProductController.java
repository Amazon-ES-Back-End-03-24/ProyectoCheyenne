package com.ironhack.inventorytool.controllers;

import com.ironhack.inventorytool.entities.Product;
import com.ironhack.inventorytool.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/inventory")
    @PreAuthorize("hasRole('ADMIN') or hasRole('INVENTORY_MANAGER')")
    public List<Product> getAllProductsWithInventory() {
        return productService.getAllProductsWithInventory();
    }

    @GetMapping("/public")
    public List<Product> getAllProductsForPublic() {
        return productService.getAllProductsForPublic();
    }
}
