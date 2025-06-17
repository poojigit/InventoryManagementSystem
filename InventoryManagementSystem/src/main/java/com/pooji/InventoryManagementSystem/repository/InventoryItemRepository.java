package com.pooji.InventoryManagementSystem.repository;

import com.pooji.InventoryManagementSystem.domain.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {

    InventoryItem findByName(String name);

    //your own method other than CRUD which is not available in the JpaRepository


}