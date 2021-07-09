package com.demo.laptopshop.controller;



import com.demo.laptopshop.exception.ResourceNotFoundException;
import com.demo.laptopshop.model.Products;
import com.demo.laptopshop.repo.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    ProductsRepo productsRepo;

    @GetMapping("/")
    private List<Products> getProducts()  {
        return productsRepo.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Products> getProduct(@PathVariable Long id)    {
        Products product = productsRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Product not exist " + id));
        return ResponseEntity.ok(product);
    }

    @PostMapping("/{id}")
    public Products PostProduct(@RequestBody Products product) {
        return productsRepo.save(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Products> PutProduct(@RequestBody Products product, @PathVariable Long id)  {
        Products newProduct = productsRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product not exist " + id));
        newProduct.setName(product.getName());
        newProduct.setBest_seller(product.getBest_seller());
        newProduct.setDescription(product.getDescription());
        newProduct.setCate_id(product.getCate_id());
        newProduct.setRegular_price(product.getRegular_price());
        newProduct.setShort_desc(product.getShort_desc());
        newProduct.setFeatured(product.getFeatured());
        newProduct.setUpdate_at(product.getUpdate_at());
        newProduct.setThumbnail(product.getThumbnail());
        newProduct.setSlug(product.getSlug());
        newProduct.setSale_price(product.getSale_price());
        Products updateProduct = productsRepo.save(newProduct);
        return ResponseEntity.ok(updateProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable Long id)    {
        Products product = productsRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product not exist " + id));
        productsRepo.delete(product);
        Map<String, Boolean> reponse = new HashMap<>();
        reponse.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(reponse);
    }
}
