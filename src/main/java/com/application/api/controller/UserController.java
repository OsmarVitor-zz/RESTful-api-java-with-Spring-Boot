package com.application.api.controller;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.application.api.models.User;
import com.application.api.service.UserServiceImpl;

@RestController
@RequestMapping("/api/user")
public class UserController {
 
    @Autowired
    private UserServiceImpl service;

    @GetMapping("all")
    public List<UserDTO> listUsers() {
        return service.findAll();
    }

    @PostMapping("save")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        System.out.println("requisicao recebida");
        User user = service.save(userDTO);
        return ResponseEntity.ok(userDTO)
                .created(URI.create("/api/users/" + user.getIdentifier()))
                .build();
    }

    @GetMapping(value = "find/{identifier}")
    public ResponseEntity<UserDTO> getUserByIdentifier(
            @PathVariable(name = "identifier", required = true) String identifier) {
        return ResponseEntity.ok(service.findByIdentifier(identifier));
    }

    @PutMapping("update/{identifier}")
    public ResponseEntity<UserDTO> updateUser(
            @PathVariable(value = "identifier") String identifier,
            @RequestBody UserDTO userDTO) {
        service.updateUser(userDTO, identifier);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{identifier}")
    public ResponseEntity<Void> deleteUser(@PathVariable String identifier) {
        service.deleteUser(identifier);
        return ResponseEntity.noContent().build();
    }

}
