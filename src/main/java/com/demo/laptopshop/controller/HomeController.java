package com.demo.laptopshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    HttpServletRequest request;

    public static List<String> list = Arrays.asList(new String[]{"categories", "category-product", "coupon", "menus", "news", "note", "options", "orderview", "product-images", "products", "slides", "submit-contact", "users"});

    @GetMapping("/")
    public String Home(Model model) {
        model.addAttribute("links", list);
        model.addAttribute("url", request.getRequestURL().toString());
        return "home";
    }
}
