package com.ztardz.ztaradminapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "permissions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionEntity extends AbstractEntity {
    @Column(name = "action", length=50, nullable=false)
    private String action;

    @Column(name = "name", length=50,unique = true)
    private String name;

    @Column(name = "guard_name", length=50, nullable=false)
    private String guardName = "web";

    @ManyToMany(mappedBy = "permissions" ,fetch = FetchType.LAZY)
    List<RoleEntity> roles;

    @ManyToMany(mappedBy = "permissions",fetch = FetchType.LAZY)
    List<UserEntity> users;

    /*@OneToOne(mappedBy = "permission",fetch = FetchType.LAZY)
    private MenuItemEntity menuItem;*/

    @ManyToOne(fetch = FetchType.EAGER)
    private CollectionEntity collection;
}
