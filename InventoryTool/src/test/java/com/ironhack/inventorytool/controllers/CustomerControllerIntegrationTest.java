package com.ironhack.inventorytool.controllers;

import com.ironhack.inventorytool.entities.Customer;
import com.ironhack.inventorytool.repositories.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CustomerRepository customerRepository;

    private String baseUrl = "/api/customers";

    @BeforeEach
    public void setup() {
        customerRepository.deleteAll();
    }

    @Test
    public void testGetCustomerById() {
        // Insertar un cliente de prueba en la base de datos
        Customer customer = new Customer();
        customer.setName("Cheyenne Saiz");
        customer = customerRepository.save(customer);

        // Realizar una solicitud GET para obtener el cliente por ID
        ResponseEntity<Customer> response = restTemplate.exchange(
                baseUrl + "/" + customer.getId(),
                HttpMethod.GET,
                null,
                Customer.class
        );

        // Verificar la respuesta
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Cheyenne Saiz", response.getBody().getName());
    }

    @Test
    public void testCreateCustomer() {
        // Crear un cliente de prueba
        Customer customer = new Customer();
        customer.setName("Elsa Lorente");

        // Realizar una solicitud POST para crear el cliente
        ResponseEntity<Customer> response = restTemplate.postForEntity(
                baseUrl,
                customer,
                Customer.class
        );

        // Verificar la respuesta
        assertEquals(201, response.getStatusCodeValue());
        assertEquals("Elsa Lorente", response.getBody().getName());
    }
}
