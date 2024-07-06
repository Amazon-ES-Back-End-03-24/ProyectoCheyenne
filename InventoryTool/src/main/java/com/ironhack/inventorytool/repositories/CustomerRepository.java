package com.ironhack.inventorytool.repositories;

import com.ironhack.inventorytool.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByName(String cheyenneSaiz);
}
