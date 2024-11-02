package com.bandhan.order.service.impl;

import com.bandhan.order.dto.CustomerDetails;
import com.bandhan.order.entity.Customer;
import com.bandhan.order.repository.CustomerRepo;
import com.bandhan.order.service.CustomerService;
import javassist.NotFoundException;
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

    @Override
    public Customer getCustomer(String username) throws NotFoundException {
        Optional<Customer> customer = customerRepo.findByUsername(username);
        if (customer.isEmpty()) {
            throw new NotFoundException(String.format("Customer not found with username: %s", username));
        }
        return customer.get();
    }
}
