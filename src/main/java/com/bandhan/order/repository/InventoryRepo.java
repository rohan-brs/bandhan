package com.bandhan.order.repository;

import com.bandhan.order.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory, Integer> {

    Optional<Inventory> findByItemId(int itemId);
}
