package com.demo.laptopshop.repo;

import com.demo.laptopshop.model.Categories;
import com.demo.laptopshop.model.CategoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepo extends JpaRepository<Categories, Long> {
}
