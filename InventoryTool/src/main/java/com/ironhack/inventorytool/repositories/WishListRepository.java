package com.ironhack.inventorytool.repositories;

import com.ironhack.inventorytool.entities.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListRepository extends JpaRepository<WishList, Long> {
    WishList findByCustomerId(Long customerId);
}
