package com.application.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.api.dto.UserDTO;

import service.UserServiceImpl;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @Autowired
    private UserServiceImpl service;
 
    @GetMapping()
    public List<UserDTO> listUsers() {
        return service.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        service.save(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{identifier}")
    public ResponseEntity<UserDTO> getUserByIdentifier(
            @PathVariable String identifier) {
        return ResponseEntity.ok(service.findByIdentifier(identifier));
    }

    @PutMapping("/{identifier}")
    public ResponseEntity<UserDTO> updateUser(
            @PathVariable(value = "identifier") String identifier,
            @RequestBody UserDTO userDTO) {
        service.updateUser(userDTO, identifier);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{identifier}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable String identifier) {
        service.deleteUser(identifier);
        return ResponseEntity.noContent().build();
    }

}
