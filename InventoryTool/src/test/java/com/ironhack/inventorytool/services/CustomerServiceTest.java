package com.ironhack.inventorytool.services;

import entities.Customer;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repositories.CustomerRepository;
import services.CustomerService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    public CustomerServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindCustomerById() {
        Customer customer = new Customer();
        customer.setIdCustomer(1L);
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

    @Test
    public void testUpdateCustomer() {
        Customer customer = new Customer();
        customer.setIdCustomer(1L);
        customer.setName("Elsa Lorente");

        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
        when(customerRepository.save(customer)).thenReturn(customer);

        Customer updatedCustomer = customerService.updateCustomer(1L, customer);

        assertEquals("Elsa Lorente", updatedCustomer.getName());
    }

    @Test
    public void testDeleteCustomer() {
        Customer customer = new Customer();
        customer.setIdCustomer(1L);

        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));

        customerService.deleteCustomer(1L);

        verify(customerRepository, times(1)).deleteById(1L);
    }
}
