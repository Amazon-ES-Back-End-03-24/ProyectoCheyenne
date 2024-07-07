package com.ironhack.inventorytool.services;

import com.ironhack.inventorytool.entities.Customer;
import com.ironhack.inventorytool.entities.Product;
import com.ironhack.inventorytool.entities.WishList;
import com.ironhack.inventorytool.repositories.CustomerRepository;
import com.ironhack.inventorytool.repositories.ProductRepository;
import com.ironhack.inventorytool.repositories.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WishListService {

    @Autowired
    private WishListRepository wishListRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    public WishList addProductToWishList(Long customerId, Long productId) {
        // Buscar el cliente en la tabla correcta
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (!optionalCustomer.isPresent()) {
            throw new RuntimeException("Customer not found");
        }

        // Buscar el producto
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (!optionalProduct.isPresent()) {
            throw new RuntimeException("Product not found");
        }

        Customer customer = optionalCustomer.get();
        Product product = optionalProduct.get();

        // Obtener o crear la wishlist del cliente
        WishList wishList = wishListRepository.findByCustomerId(customerId);
        if (wishList == null) {
            wishList = new WishList();
            wishList.setCustomer(customer);
        }

        // Inicializa la lista de productos si es nula
        if (wishList.getProducts() == null) {
            wishList.setProducts(new ArrayList<>());
        }

        // Agregar el producto a la wishlist
        wishList.getProducts().add(product);
        return wishListRepository.save(wishList);
    }

    public WishList getWishListByCustomerId(Long customerId) {
        return wishListRepository.findByCustomerId(customerId);
    }

    public List<WishList> getAllWishLists() {
        return wishListRepository.findAll();
    }

    // Método para eliminar un producto de la wishlist
    public WishList removeProductFromWishList(Long customerId, Long productId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (!optionalCustomer.isPresent()) {
            throw new RuntimeException("Customer not found");
        }

        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (!optionalProduct.isPresent()) {
            throw new RuntimeException("Product not found");
        }

        WishList wishList = wishListRepository.findByCustomerId(customerId);
        if (wishList == null || wishList.getProducts() == null) {
            throw new RuntimeException("Wishlist not found");
        }

        wishList.getProducts().removeIf(product -> product.getId().equals(productId));
        return wishListRepository.save(wishList);
    }
}
