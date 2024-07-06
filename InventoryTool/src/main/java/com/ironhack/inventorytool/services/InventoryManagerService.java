package com.ironhack.inventorytool.services;

import com.ironhack.inventorytool.entities.InventoryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ironhack.inventorytool.repositories.InventoryManagerRepository;

import java.util.List;

@Service
public class InventoryManagerService {

    @Autowired
    private InventoryManagerRepository inventoryManagerRepository;

    public List<InventoryManager> getAllInventoryManagers() {
        return inventoryManagerRepository.findAll();
    }

    public InventoryManager getInventoryManagerById(Long id) {
        return inventoryManagerRepository.findById(id).orElse(null);
    }

    public InventoryManager saveInventoryManager(InventoryManager inventoryManager) {
        return inventoryManagerRepository.save(inventoryManager);
    }

    public void deleteInventoryManager(Long id) {
        inventoryManagerRepository.deleteById(id);
    }
}
