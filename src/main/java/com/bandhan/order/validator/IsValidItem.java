package com.bandhan.order.validator;

import com.bandhan.order.validator.impl.ItemValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD })
@Constraint(validatedBy = {ItemValidator.class})
public @interface IsValidItem {

    String message() default "Invalid item";
}
