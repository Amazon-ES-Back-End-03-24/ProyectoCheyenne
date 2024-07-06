package com.ironhack.inventorytool.controllers;




import com.ironhack.inventorytool.entities.Inventory;
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
import com.ironhack.inventorytool.repositories.InventoryRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InventoryControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private InventoryRepository inventoryRepository;

    private String baseUrl;

    @BeforeEach
    public void setUp() {
        baseUrl = "http://localhost:" + port + "/api/inventories";
    }

    @Test
    public void testGetInventoryById() {
        // Insertar un inventario de prueba en la base de datos
        Inventory inventory = new Inventory();
        inventory.setName("Warehouse 1");
        inventory = inventoryRepository.save(inventory);

        // Realizar una solicitud GET para obtener el inventario
        ResponseEntity<Inventory> response = restTemplate.exchange(
                baseUrl + "/" + inventory.getIdInventory(),
                HttpMethod.GET,
                new HttpEntity<>(new HttpHeaders()),
                Inventory.class
        );

        // Verificar la respuesta
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Warehouse 1", response.getBody().getName());
    }

    @Test
    public void testCreateInventory() {
        // Crear un inventario de prueba
        Inventory inventory = new Inventory();
        inventory.setName("Warehouse 2");

        // Realizar una solicitud POST para crear el inventario
        ResponseEntity<Inventory> response = restTemplate.postForEntity(
                baseUrl,
                inventory,
                Inventory.class
        );

        // Verificar la respuesta
        assertEquals(201, response.getStatusCodeValue());
        assertEquals("Warehouse 2", response.getBody().getName());
    }

    @Test
    public void testUpdateInventory() {
        // Insertar un inventario de prueba en la base de datos
        Inventory inventory = new Inventory();
        inventory.setName("Warehouse 1");
        inventory = inventoryRepository.save(inventory);

        // Actualizar el inventario
        inventory.setName("Updated Warehouse");

        // Realizar una solicitud PUT para actualizar el inventario
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Inventory> entity = new HttpEntity<>(inventory, headers);
        ResponseEntity<Inventory> response = restTemplate.exchange(
                baseUrl + "/" + inventory.getIdInventory(),
                HttpMethod.PUT,
                entity,
                Inventory.class
        );

        // Verificar la respuesta
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Updated Warehouse", response.getBody().getName());
    }

    @Test
    public void testDeleteInventory() {
        // Insertar un inventario de prueba en la base de datos
        Inventory inventory = new Inventory();
        inventory.setName("Warehouse 1");
        inventory = inventoryRepository.save(inventory);

        // Realizar una solicitud DELETE para eliminar el inventario
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Inventory> entity = new HttpEntity<>(headers);
        ResponseEntity<Void> response = restTemplate.exchange(
                baseUrl + "/" + inventory.getIdInventory(),
                HttpMethod.DELETE,
                entity,
                Void.class
        );

        // Verificar la respuesta
        assertEquals(204, response.getStatusCodeValue());
    }
}
