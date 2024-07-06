package com.ironhack.inventorytool.services;

import com.ironhack.inventorytool.entities.Inventory;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.ironhack.inventorytool.repositories.InventoryRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class InventoryServiceTest {

    @Mock
    private InventoryRepository inventoryRepository;

    @InjectMocks
    private InventoryService inventoryService;

    public InventoryServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindInventoryById() {
        Inventory inventory = new Inventory();
        inventory.setIdInventory(1L);
        inventory.setName("Warehouse 1");

        when(inventoryRepository.findById(1L)).thenReturn(Optional.of(inventory));

        Inventory foundInventory = inventoryService.findInventoryById(1L);

        assertEquals("Warehouse 1", foundInventory.getName());
    }

    @Test
    public void testCreateInventory() {
        Inventory inventory = new Inventory();
        inventory.setName("Warehouse 2");

        when(inventoryRepository.save(inventory)).thenReturn(inventory);

        Inventory createdInventory = inventoryService.createInventory(inventory);

        assertEquals("Warehouse 2", createdInventory.getName());
    }

    @Test
    public void testUpdateInventory() {
        Inventory inventory = new Inventory();
        inventory.setIdInventory(1L);
        inventory.setName("Updated Warehouse");

        when(inventoryRepository.findById(1L)).thenReturn(Optional.of(inventory));
        when(inventoryRepository.save(inventory)).thenReturn(inventory);

        Inventory updatedInventory = inventoryService.updateInventory(1L, inventory);

        assertEquals("Updated Warehouse", updatedInventory.getName());
    }

    @Test
    public void testDeleteInventory() {
        Inventory inventory = new Inventory();
        inventory.setIdInventory(1L);

        when(inventoryRepository.findById(1L)).thenReturn(Optional.of(inventory));

        inventoryService.deleteInventory(1L);

        verify(inventoryRepository, times(1)).deleteById(1L);
    }
}
