package com.ironhack.inventorytool.services;

import com.ironhack.inventorytool.entities.Inventory;
import com.ironhack.inventorytool.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }

    public Inventory getInventoryById(Long id) {
        return inventoryRepository.findById(id).orElse(null);
    }

    public Inventory saveInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public void deleteInventory(Long id) {
        inventoryRepository.deleteById(id);
    }

    public Inventory findInventoryById(long l) {
        return null;
    }

    public Inventory createInventory(Inventory inventory) {
        return inventory;
    }

    public Inventory updateInventory(long l, Inventory inventory) {
        return inventory;
    }
}
