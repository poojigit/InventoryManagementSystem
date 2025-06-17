package com.pooji.InventoryManagementSystem.service;

import com.pooji.InventoryManagementSystem.domain.InventoryItem;
import com.pooji.InventoryManagementSystem.repository.InventoryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryItemService {

    @Autowired
    private InventoryItemRepository inventoryItemRepository;

    public List<InventoryItem> getAllItems() {

        return inventoryItemRepository.findAll();
    }

    public InventoryItem addItem(InventoryItem item) {

        return inventoryItemRepository.save(item);
    }

    public void deleteItemById(Long id) {
        inventoryItemRepository.deleteById(id);
    }




    // Other business logic methods
}