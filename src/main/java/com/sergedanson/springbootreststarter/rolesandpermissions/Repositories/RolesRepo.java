package com.sergedanson.springbootreststarter.rolesandpermissions.Repositories;

import com.sergedanson.springbootreststarter.rolesandpermissions.Modules.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
