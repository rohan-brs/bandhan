package com.bandhan.order.service;

import com.bandhan.order.dto.CustomerDetails;

public interface CustomerService {

    boolean isValidCustomer(CustomerDetails customerDetails);
}
