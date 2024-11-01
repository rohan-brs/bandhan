package com.bandhan.order.dto;

import com.bandhan.order.validator.IsValidItem;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class CreateOrderRequest {

    @IsValidItem
    private int itemId;

    private CustomerDetails customer;

    @Min(value = 1, message = "Number of items must be at least 1")
    private int noOfItem;
}
