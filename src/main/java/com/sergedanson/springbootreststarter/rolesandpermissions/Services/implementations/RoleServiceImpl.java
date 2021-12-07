package com.sergedanson.springbootreststarter.rolesandpermissions.Services.implementations;

import com.sergedanson.springbootreststarter.rolesandpermissions.Modules.Role;
import com.sergedanson.springbootreststarter.rolesandpermissions.Repositories.RolesRepo;
import com.sergedanson.springbootreststarter.rolesandpermissions.Services.RoleServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RoleServiceImpl implements RoleServices {

    private final RolesRepo rolesRepo;

    @Override
    public Role saveRole(Role role) {
        log.info("saving role {} to DB", role.getName());
        return rolesRepo.save(role);
    }

    @Override
    public List<Role> getRoles() {
        log.info("fetching all roles");
        return rolesRepo.findAll();
    }
}
