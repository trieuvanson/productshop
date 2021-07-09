package com.demo.laptopshop.controller;


import com.demo.laptopshop.exception.ResourceNotFoundException;
import com.demo.laptopshop.model.Coupon;
import com.demo.laptopshop.repo.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/coupon")
public class CouponController {
    @Autowired
    CouponRepo couponRepo;

    @GetMapping("/")
    private List<Coupon> getCoupons()  {
        return couponRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coupon> getCoupon(@PathVariable Long id)    {
        Coupon Coupon = couponRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Coupon not exist " + id));
        return ResponseEntity.ok(Coupon);
    }

    @PostMapping("/")
    public Coupon PostCoupon(@RequestBody Coupon Coupon) {
        return couponRepo.save(Coupon);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coupon> PutCoupon(@RequestBody Coupon Coupon, @PathVariable Long id)  {
        Coupon newCoupon = couponRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Coupon not exist " + id));
        newCoupon.setCode(Coupon.getCode());
        newCoupon.setStatus(Coupon.getStatus());
        newCoupon.setType(Coupon.getType());
        newCoupon.setValue(Coupon.getValue());
        newCoupon.setDate_end(Coupon.getDate_end());
        newCoupon.setUpdate_at(Coupon.getUpdate_at());
        Coupon updateCoupon = couponRepo.save(newCoupon);
        return ResponseEntity.ok(updateCoupon);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCoupon(@PathVariable Long id)    {
        Coupon Coupon = couponRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Coupon not exist " + id));
        couponRepo.delete(Coupon);
        Map<String, Boolean> reponse = new HashMap<>();
        reponse.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(reponse);
    }
}
