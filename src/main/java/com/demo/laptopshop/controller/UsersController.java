package com.demo.laptopshop.controller;


import com.demo.laptopshop.exception.ResourceNotFoundException;
import com.demo.laptopshop.model.Users;
import com.demo.laptopshop.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/users")
public class UsersController {
    @Autowired
    UsersRepo usersRepo;

    @GetMapping("/")
    private List<Users> getUsers()  {
        return usersRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUser(@PathVariable Long id)    {
        Users User = usersRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User not exist " + id));
        return ResponseEntity.ok(User);
    }

    @PostMapping("/")
    public Users PostUsers(@RequestBody Users User) {
        return usersRepo.save(User);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> PutUsers(@RequestBody Users Users, @PathVariable Long id)  {
        Users newUser = usersRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User not exist " + id));
        newUser.setEmail(Users.getEmail());
        newUser.setPassword(Users.getPassword());
        newUser.setPhone(Users.getPhone());
        newUser.setFullname(Users.getFullname());
        newUser.setForgot_code(Users.getForgot_code());
        newUser.setUpdate_at(Users.getUpdate_at());
        Users updateUser = usersRepo.save(newUser);
        return ResponseEntity.ok(updateUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUsers(@PathVariable Long id)    {
        Users User = usersRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User not exist " + id));
        usersRepo.delete(User);
        Map<String, Boolean> reponse = new HashMap<>();
        reponse.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(reponse);
    }
}
