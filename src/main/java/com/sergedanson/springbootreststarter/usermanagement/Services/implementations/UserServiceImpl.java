package com.sergedanson.springbootreststarter.usermanagement.Services.implementations;

import com.sergedanson.springbootreststarter.rolesandpermissions.Modules.Role;
import com.sergedanson.springbootreststarter.rolesandpermissions.Repositories.RolesRepo;
import com.sergedanson.springbootreststarter.usermanagement.Modules.User;
import com.sergedanson.springbootreststarter.usermanagement.Repositories.UserRepo;
import com.sergedanson.springbootreststarter.usermanagement.Services.UserServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserServices, UserDetailsService {
    private final UserRepo userRepo;
    private final RolesRepo rolesRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepo.findByUsername(username);
        if(user == null){
            log.error("user {} is not found ", username);
            throw new UsernameNotFoundException("User not found!");
        }
       else{
           log.info("User {} is found", username);
        }


       Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

       user.getRoles().forEach(role ->{
           authorities.add(new SimpleGrantedAuthority(role.getName()));
       });

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public User saveUser(User user) {
        log.info("Saving user to DB {}", user.getUsername());
        return userRepo.save(user);
    }

    @Override
    public User getUser(String username) {
        log.info("fetching user details {}", username);
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("listing user information");
        return userRepo.findAll();
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {}", roleName, username);
        User user = userRepo.findByUsername(username);
        Role role = rolesRepo.findByName(roleName);
        user.getRoles().add(role);
    }


}
