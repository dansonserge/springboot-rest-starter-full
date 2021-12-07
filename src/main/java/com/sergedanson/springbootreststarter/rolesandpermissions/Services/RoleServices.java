package com.sergedanson.springbootreststarter.rolesandpermissions.Services;

import com.sergedanson.springbootreststarter.rolesandpermissions.Modules.Role;
import java.util.List;



public interface RoleServices {
    Role saveRole(Role role);
    List<Role> getRoles();
}
