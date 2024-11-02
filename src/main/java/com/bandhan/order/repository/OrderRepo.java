package com.bandhan.order.repository;

import com.bandhan.order.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<OrderDetails, Integer> {
}
