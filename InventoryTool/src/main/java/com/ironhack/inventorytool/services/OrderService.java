package com.ironhack.inventorytool.services;

import com.ironhack.inventorytool.entities.Inventory;
import com.ironhack.inventorytool.entities.Order;
import com.ironhack.inventorytool.repositories.InventoryRepository;
import com.ironhack.inventorytool.repositories.OrderRepository;
import com.ironhack.inventorytool.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order createOrder(Order order) {
        Inventory inventory = inventoryRepository.findByProductId(order.getProducts().get(0).getId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado en inventario"));

        if (inventory.getAvailableQuantity() < order.getQuantity()) {
            throw new RuntimeException("Stock insuficiente");
        }

        order.setDate(LocalDateTime.now());
        Order savedOrder = orderRepository.save(order);

        inventory.setAvailableQuantity(inventory.getAvailableQuantity() - order.getQuantity());
        inventoryRepository.save(inventory);

        return savedOrder;
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public Order updateOrder(Long id, Order order) {
        return orderRepository.save(order);
    }
}
