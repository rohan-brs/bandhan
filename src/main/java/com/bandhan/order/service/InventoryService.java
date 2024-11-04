package com.bandhan.order.service;

import com.bandhan.order.dto.CreateOrderRequest;
import com.bandhan.order.entity.Inventory;
import javassist.NotFoundException;

public interface InventoryService {

    boolean isValidInventory(CreateOrderRequest createOrderRequest);

    Inventory getInventory(int itemId) throws NotFoundException;

    void updateInventory(int itemId, int usedInventory) throws NotFoundException;
}
