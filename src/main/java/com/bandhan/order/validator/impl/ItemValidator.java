package com.bandhan.order.validator.impl;

import com.bandhan.order.entity.Item;
import com.bandhan.order.repository.ItemRepo;
import com.bandhan.order.validator.IsValidItem;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ItemValidator implements ConstraintValidator<IsValidItem, Integer> {

    @Autowired
    private ItemRepo itemRepo;

    @Override
    public boolean isValid(Integer itemId, ConstraintValidatorContext constraintValidatorContext) {
        Optional<Item> item = itemRepo.findById(itemId);
        return item.isPresent();
    }
}
