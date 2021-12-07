package com.sergedanson.springbootreststarter.usermanagement.Controllers;

import com.sergedanson.springbootreststarter.usermanagement.Modules.User;
import com.sergedanson.springbootreststarter.usermanagement.Services.UserServices;
import com.sergedanson.springbootreststarter.usermanagement.dto.UserRoleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class UsersController {
    private final UserServices userServices;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok(userServices.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/v1/user/save").toUriString());
        return ResponseEntity.created(uri).body(userServices.saveUser(user));
    }

    @PostMapping("/user/role/add")
    public ResponseEntity<?> addRoleToUser(@RequestBody UserRoleDto userRoleDto){
        userServices.addRoleToUser(userRoleDto.getUsername(), userRoleDto.getRoleName());
        return ResponseEntity.ok().build();
    }


}
