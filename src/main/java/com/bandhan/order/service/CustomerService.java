package com.bandhan.order.service;

import com.bandhan.order.dto.CustomerDetails;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    boolean isValidCustomer(CustomerDetails customerDetails);
}
