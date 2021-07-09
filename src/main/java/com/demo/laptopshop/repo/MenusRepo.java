package com.demo.laptopshop.repo;

import com.demo.laptopshop.model.Menus;
import com.demo.laptopshop.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenusRepo extends JpaRepository<Menus, Long> {
}
