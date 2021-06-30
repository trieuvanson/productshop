package com.demo.laptopshop.controller;



import com.demo.laptopshop.exception.ResourceNotFoundException;
import com.demo.laptopshop.model.Product;
import com.demo.laptopshop.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    ProductRepo productRepo;

    @GetMapping("/")
    private List<Product> getProducts()  {
        return productRepo.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id)    {
        Product product = productRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Product not exist " + id));
        return ResponseEntity.ok(product);
    }

    @PostMapping("/{id}")
    public Product PostProduct(@RequestBody Product product) {
        return productRepo.save(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> PutProduct(@RequestBody Product product, @PathVariable Long id)  {
        Product newProduct = productRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product not exist " + id));
        newProduct.setName(product.getName());
        newProduct.setCreatedate(product.getCreatedate());
        newProduct.setAvaiable(product.getAvaiable());
        newProduct.setCurrentPrice(product.getCurrentPrice());
        newProduct.setBeforePrice(product.getBeforePrice());
        newProduct.setCategoryId(product.getCategoryId());
        newProduct.setImages(product.getImages());
        Product updateProduct = productRepo.save(newProduct);
        return ResponseEntity.ok(updateProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable Long id)    {
        Product product = productRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product not exist " + id));
        productRepo.delete(product);
        Map<String, Boolean> reponse = new HashMap<>();
        reponse.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(reponse);
    }
}
