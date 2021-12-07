package com.sergedanson.springbootreststarter.rolesandpermissions.Services;

import com.sergedanson.springbootreststarter.rolesandpermissions.Modules.Role;

public interface RoleServices {
    void addRoleToUser(String username, String roleName);
    Role saveRole(Role role);
}
