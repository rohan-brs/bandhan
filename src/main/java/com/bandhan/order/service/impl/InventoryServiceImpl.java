package com.bandhan.order.service.impl;

import com.bandhan.order.dto.CreateOrderRequest;
import com.bandhan.order.entity.Inventory;
import com.bandhan.order.repository.InventoryRepo;
import com.bandhan.order.service.InventoryService;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepo inventoryRepo;

    @Override
    public boolean isValidInventory(CreateOrderRequest createOrderRequest) {
        Optional<Inventory> inventory = inventoryRepo.findByItemId(createOrderRequest.getItemId());
        if (inventory.isEmpty()) {
            return false;
        }
        Inventory item = inventory.get();
        return item.getInventoryBalance() >= createOrderRequest.getNoOfItem();
    }

    @Override
    public Inventory getInventory(int itemId) throws NotFoundException {
        log.info("Fetching inventory for itemId: {}", itemId);
        Optional<Inventory> inventory = inventoryRepo.findByItemId(itemId);
        if (inventory.isEmpty()) {
            throw new NotFoundException(String.format("Item not found with itemId: %s", itemId));
        }
        return inventory.get();
    }

    @Override
    public void updateInventory(int itemId, int usedInventory) throws NotFoundException {
        Optional<Inventory> inventory = inventoryRepo.findByItemId(itemId);
        if (inventory.isEmpty()) {
            throw new NotFoundException(String.format("Inventory not found. Invalid itemId: %s", itemId));
        }
        Inventory item = inventory.get();
        item.setInventoryBalance(item.getInventoryBalance() - usedInventory);
        inventoryRepo.save(item);
    }
}
