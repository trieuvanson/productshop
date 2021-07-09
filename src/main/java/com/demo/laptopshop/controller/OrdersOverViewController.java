package com.demo.laptopshop.controller;


import com.demo.laptopshop.exception.ResourceNotFoundException;
import com.demo.laptopshop.model.OrdersOverView;
import com.demo.laptopshop.repo.OrdersOverViewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/orderview")
public class OrdersOverViewController {
    @Autowired
    OrdersOverViewRepo ordersOverViewRepo;

    @GetMapping("/")
    private List<OrdersOverView> getOrdersOverViews()  {
        return ordersOverViewRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdersOverView> getOrdersOverView(@PathVariable Long id)    {
        OrdersOverView OrdersOverView = ordersOverViewRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("OrdersOverView not exist " + id));
        return ResponseEntity.ok(OrdersOverView);
    }

    @PostMapping("/")
    public OrdersOverView PostOrdersOverView(@RequestBody OrdersOverView OrdersOverView) {
        return ordersOverViewRepo.save(OrdersOverView);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdersOverView> PutOrdersOverView(@RequestBody OrdersOverView OrdersOverView, @PathVariable Long id)  {
        OrdersOverView newOrdersOverView = ordersOverViewRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("OrdersOverView not exist " + id));
        newOrdersOverView.setCus_id(OrdersOverView.getCus_id());
        newOrdersOverView.setTotal(OrdersOverView.getTotal());
        newOrdersOverView.setDiscount(OrdersOverView.getDiscount());
        newOrdersOverView.setStatus(OrdersOverView.getStatus());
        newOrdersOverView.setSub_total(OrdersOverView.getSub_total());
        newOrdersOverView.setUpdate_at(OrdersOverView.getUpdate_at());
        OrdersOverView updateOrdersOverView = ordersOverViewRepo.save(newOrdersOverView);
        return ResponseEntity.ok(updateOrdersOverView);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteOrdersOverView(@PathVariable Long id)    {
        OrdersOverView OrdersOverView = ordersOverViewRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("OrdersOverView not exist " + id));
        ordersOverViewRepo.delete(OrdersOverView);
        Map<String, Boolean> reponse = new HashMap<>();
        reponse.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(reponse);
    }
}
