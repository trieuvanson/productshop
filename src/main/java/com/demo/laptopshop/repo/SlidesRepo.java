package com.demo.laptopshop.repo;

import com.demo.laptopshop.model.Options;
import com.demo.laptopshop.model.Slides;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlidesRepo extends JpaRepository<Slides, Long> {
}
