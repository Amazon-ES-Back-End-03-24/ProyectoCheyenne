package com.ironhack.inventorytool.repositories;


import com.ironhack.inventorytool.entities.Inventory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class InventoryRepositoryTest {

    @Autowired
    private InventoryRepository inventoryRepository;

   @Test
    public void testFindByName() {
        Inventory inventory = new Inventory();
        inventory.setName("Warehouse 1");
        inventoryRepository.save(inventory);

        Inventory foundInventory = inventoryRepository.findByName("Warehouse 1");

        assertEquals("Warehouse 1", foundInventory.getName());
    }
}
