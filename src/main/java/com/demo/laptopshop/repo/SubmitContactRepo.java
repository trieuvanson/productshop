package com.demo.laptopshop.repo;

import com.demo.laptopshop.model.Slides;
import com.demo.laptopshop.model.SubmitContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmitContactRepo extends JpaRepository<SubmitContact, Long> {
}
