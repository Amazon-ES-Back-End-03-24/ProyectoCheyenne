package com.ironhack.inventorytool.repositories;




import entities.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import repositories.CustomerRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testFindByName() {
        Customer customer = new Customer();
        customer.setName("Cheyenne Saiz");
        customerRepository.save(customer);

        Customer foundCustomer = customerRepository.findByName("Cheyenne Saiz");

        assertEquals("Cheyenne Saiz", foundCustomer.getName());
    }
}
