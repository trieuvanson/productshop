package com.demo.laptopshop.repo;

import com.demo.laptopshop.model.OrdersOverView;
import com.demo.laptopshop.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersOverViewRepo extends JpaRepository<OrdersOverView, Long> {
}
