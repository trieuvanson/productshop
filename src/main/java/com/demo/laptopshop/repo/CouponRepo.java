package com.demo.laptopshop.repo;

import com.demo.laptopshop.model.Coupon;
import com.demo.laptopshop.model.Slides;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepo extends JpaRepository<Coupon, Long> {
}
