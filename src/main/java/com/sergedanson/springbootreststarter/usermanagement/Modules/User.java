package com.sergedanson.springbootreststarter.usermanagement.Modules;


import com.sergedanson.springbootreststarter.rolesandpermissions.Modules.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    @ManyToMany
    private Collection<Role> roles = new ArrayList<>();
}
