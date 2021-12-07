package com.sergedanson.springbootreststarter.usermanagement.Services;

import com.sergedanson.springbootreststarter.usermanagement.Modules.User;
import java.util.List;

public interface UserServices {
    User saveUser(User user);
    User getUser(String username);
    List<User> getUsers();
}
