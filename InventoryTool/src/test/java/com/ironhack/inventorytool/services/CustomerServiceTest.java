package com.ironhack.inventorytool.services;

import com.ironhack.inventorytool.entities.Customer;
import com.ironhack.inventorytool.repositories.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindCustomerById() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Cheyenne Saiz");

        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));

        Customer foundCustomer = customerService.findCustomerById(1L);

        assertEquals("Cheyenne Saiz", foundCustomer.getName());
    }

    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer();
        customer.setName("Elsa Lorente");

        when(customerRepository.save(customer)).thenReturn(customer);

        Customer createdCustomer = customerService.createCustomer(customer);

        assertEquals("Elsa Lorente", createdCustomer.getName());
    }
}
