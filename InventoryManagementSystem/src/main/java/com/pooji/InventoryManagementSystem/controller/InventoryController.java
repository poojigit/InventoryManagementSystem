package com.pooji.InventoryManagementSystem.controller;

import com.pooji.InventoryManagementSystem.domain.InventoryItem;
import com.pooji.InventoryManagementSystem.service.InventoryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryItemService inventoryItemService;

    @GetMapping("/items")
    public List<InventoryItem> getAllItems() {

        return inventoryItemService.getAllItems();
    }

    @PostMapping("/items")
    public InventoryItem addItem(@RequestBody InventoryItem item) {

        return inventoryItemService.addItem(item);
    }
    @DeleteMapping("/items/id/{id}")
    public ResponseEntity<Void> deleteItemById(@PathVariable Long id) {
        inventoryItemService.deleteItemById(id);
        return ResponseEntity.noContent().build();
    }





}