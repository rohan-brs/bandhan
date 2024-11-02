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
    public Inventory updateAndGetInventory(int itemId, int noOfItems) throws NotFoundException {
        log.info("Start updating inventory for itemId: {}, noOfItems: {}", itemId, noOfItems);
        Optional<Inventory> inventory = inventoryRepo.findByItemId(itemId);
        if (inventory.isEmpty()) {
            throw new NotFoundException(String.format("Item not found with itemId: %s", itemId));
        }
        Inventory item = inventory.get();
        item.setInventoryBalance(item.getInventoryBalance()-noOfItems);
        item = inventoryRepo.save(item);
        log.info("Inventory updated successfully for itemId: {}, updated inventoryBalance: {}", itemId, item.getInventoryBalance());
        return item;
    }
}
