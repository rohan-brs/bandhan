package com.bandhan.order.validator.impl;

import com.bandhan.order.entity.Inventory;
import com.bandhan.order.repository.InventoryRepo;
import com.bandhan.order.validator.IsValidItem;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ItemValidator implements ConstraintValidator<IsValidItem, Integer> {

    @Autowired
    private InventoryRepo inventoryRepo;

    @Override
    public boolean isValid(Integer itemId, ConstraintValidatorContext constraintValidatorContext) {
        Optional<Inventory> item = inventoryRepo.findByItemId(itemId);
        return item.isPresent();
    }
}
