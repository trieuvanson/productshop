package com.demo.laptopshop.controller;


import com.demo.laptopshop.exception.ResourceNotFoundException;
import com.demo.laptopshop.model.ProductImages;
import com.demo.laptopshop.repo.ProductImagesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/product-images")
public class ProductImagesController {
    @Autowired
    ProductImagesRepo productImagesRepo;

    @GetMapping("/")
    private List<ProductImages> getProductImages()  {
        return productImagesRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductImages> getProductImage(@PathVariable Long id)    {
        ProductImages ProductImage = productImagesRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("ProductImage not exist " + id));
        return ResponseEntity.ok(ProductImage);
    }

    @PostMapping("/")
    public ProductImages PostProductImage(@RequestBody ProductImages ProductImage) {
        return productImagesRepo.save(ProductImage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductImages> PutProductImage(@RequestBody ProductImages ProductImage, @PathVariable Long id)  {
        ProductImages newProductImage = productImagesRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("ProductImage not exist " + id));
        newProductImage.setProduct_id(ProductImage.getProduct_id());
        newProductImage.setImage_url(ProductImage.getImage_url());
        ProductImages updateProductImage = productImagesRepo.save(newProductImage);
        return ResponseEntity.ok(updateProductImage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteProductImage(@PathVariable Long id)    {
        ProductImages ProductImage = productImagesRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("ProductImage not exist " + id));
        productImagesRepo.delete(ProductImage);
        Map<String, Boolean> reponse = new HashMap<>();
        reponse.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(reponse);
    }
}
