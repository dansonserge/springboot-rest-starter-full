package com.sergedanson.springbootreststarter.rolesandpermissions.Modules;

import lombok.*;

import javax.persistence.*;
import static javax.persistence.GenerationType.AUTO;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;

}
