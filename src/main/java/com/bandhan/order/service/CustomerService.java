package com.bandhan.order.service;

import com.bandhan.order.dto.CustomerDetails;
import com.bandhan.order.entity.Customer;
import javassist.NotFoundException;

public interface CustomerService {

    boolean isValidCustomer(CustomerDetails customerDetails);

    Customer getCustomer(String username) throws NotFoundException;
}
