package com.demo.laptopshop.controller;


import com.demo.laptopshop.exception.ResourceNotFoundException;
import com.demo.laptopshop.model.Menus;
import com.demo.laptopshop.repo.MenusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/menus")
public class MenusController {
    @Autowired
    MenusRepo menusRepo;

    @GetMapping("/")
    private List<Menus> getAllMenus()  {
        return menusRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Menus> getMenus(@PathVariable Long id)    {
        Menus Menu = menusRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Menu not exist " + id));
        return ResponseEntity.ok(Menu);
    }

    @PostMapping("/")
    public Menus PostMenus(@RequestBody Menus Menu) {
        return menusRepo.save(Menu);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Menus> PutMenus(@RequestBody Menus Menu, @PathVariable Long id)  {
        Menus newMenu = menusRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Menu not exist " + id));
        newMenu.setTitle(Menu.getTitle());
        newMenu.setLink(Menu.getLink());
        newMenu.setParent_id(Menu.getParent_id());
        newMenu.setPostion(Menu.getPostion());
        newMenu.setUpdate_at(Menu.getUpdate_at());
        Menus updateMenus = menusRepo.save(newMenu);
        return ResponseEntity.ok(updateMenus);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteMenus(@PathVariable Long id)    {
        Menus Menu = menusRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Menu not exist " + id));
        menusRepo.delete(Menu);
        Map<String, Boolean> reponse = new HashMap<>();
        reponse.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(reponse);
    }
}
