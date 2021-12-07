package com.sergedanson.springbootreststarter.rolesandpermissions.Controllers;

import com.sergedanson.springbootreststarter.rolesandpermissions.Modules.Role;
import com.sergedanson.springbootreststarter.rolesandpermissions.Services.RoleServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class RolesController {
    private final RoleServices rolesService;

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getRoles (){
        return ResponseEntity.ok().body(rolesService.getRoles());
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        return ResponseEntity.ok(rolesService.saveRole(role));
    }
}
