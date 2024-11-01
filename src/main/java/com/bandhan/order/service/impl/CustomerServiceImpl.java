package com.bandhan.order.service.impl;

import com.bandhan.order.dto.CustomerDetails;
import com.bandhan.order.entity.Customer;
import com.bandhan.order.repository.CustomerRepo;
import com.bandhan.order.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public boolean isValidCustomer(CustomerDetails customerDetails) {
        Optional<Customer> customer = customerRepo.findByUsername(customerDetails.getUsername());
        return customer.isPresent();
    }
}
