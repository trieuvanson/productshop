package com.demo.laptopshop.repo;

import com.demo.laptopshop.model.News;
import com.demo.laptopshop.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepo extends JpaRepository<News, Long> {
}
