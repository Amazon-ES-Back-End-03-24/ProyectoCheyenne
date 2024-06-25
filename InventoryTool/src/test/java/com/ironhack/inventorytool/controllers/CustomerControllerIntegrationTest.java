package com.ironhack.inventorytool.controllers;




import entities.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import repositories.CustomerRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CustomerRepository customerRepository;

    private String baseUrl;

    @BeforeEach
    public void setUp() {
        baseUrl = "http://localhost:" + port + "/api/customers";
    }

    @Test
    public void testGetCustomerById() {
        // Insertar un cliente de prueba en la base de datos
        Customer customer = new Customer();
        customer.setName("Cheyenne Saiz ");
        customer = customerRepository.save(customer);

        // Realizar una solicitud GET para obtener el cliente
        ResponseEntity<Customer> response = restTemplate.exchange(
                baseUrl + "/" + customer.getIdCustomer(),
                HttpMethod.GET,
                new HttpEntity<>(new HttpHeaders()),
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

    @Test
    public void testUpdateCustomer() {
        // Insertar un cliente de prueba en la base de datos
        Customer customer = new Customer();
        customer.setName("Cheyenne Saiz");
        customer = customerRepository.save(customer);

        // Actualizar el cliente
        customer.setName("Cheyenne Saiz Updated");

        // Realizar una solicitud PUT para actualizar el cliente
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Customer> entity = new HttpEntity<>(customer, headers);
        ResponseEntity<Customer> response = restTemplate.exchange(
                baseUrl + "/" + customer.getIdCustomer(),
                HttpMethod.PUT,
                entity,
                Customer.class
        );

        // Verificar la respuesta
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Cheyenne Saiz  Updated", response.getBody().getName());
    }

    @Test
    public void testDeleteCustomer() {
        // Insertar un cliente de prueba en la base de datos
        Customer customer = new Customer();
        customer.setName("Cheyenne Saiz");
        customer = customerRepository.save(customer);

        // Realizar una solicitud DELETE para eliminar el cliente
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Customer> entity = new HttpEntity<>(headers);
        ResponseEntity<Void> response = restTemplate.exchange(
                baseUrl + "/" + customer.getIdCustomer(),
                HttpMethod.DELETE,
                entity,
                Void.class
        );

        // Verificar la respuesta
        assertEquals(204, response.getStatusCodeValue());
    }
}
