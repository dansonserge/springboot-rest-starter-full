package com.sergedanson.springbootreststarter.usermanagement.Repositories;

import com.sergedanson.springbootreststarter.usermanagement.Modules.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
