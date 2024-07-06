package com.ironhack.inventorytool.repositories;



import com.ironhack.inventorytool.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
