package com.bandhan.order.service;

import com.bandhan.order.dto.CreateOrderRequest;
import com.bandhan.order.entity.Inventory;
import javassist.NotFoundException;

public interface InventoryService {

    boolean isValidInventory(CreateOrderRequest createOrderRequest);

    Inventory updateAndGetInventory(int itemId, int noOfItems) throws NotFoundException;
}
