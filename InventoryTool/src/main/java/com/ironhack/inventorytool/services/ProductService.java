package com.ironhack.inventorytool.services;

import com.ironhack.inventorytool.entities.Product;
import com.ironhack.inventorytool.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getAllProductsWithInventory() {
        return productRepository.findAll();
    }

    public List<Product> getAllProductsForPublic() {
        return productRepository.findAll().stream()
                .map(product -> {
                    Product publicProduct = new Product();
                    publicProduct.setId(product.getId());
                    publicProduct.setName(product.getName());
                    publicProduct.setPrice(product.getPrice());
                    return publicProduct;
                }).collect(Collectors.toList());
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long idProduct, Product product) {
        Product existingProduct = productRepository.findById(idProduct).orElse(null);
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setQuantity(product.getQuantity());
            existingProduct.setWishListCount(product.getWishListCount());
            existingProduct.setInventoryManager(product.getInventoryManager());
            return productRepository.save(existingProduct);
        } else {
            return null;
        }
    }
}
