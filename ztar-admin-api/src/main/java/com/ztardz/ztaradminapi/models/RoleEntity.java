package com.ztardz.ztaradminapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntity extends AbstractEntity {
    @Column(name = "name", length=50, nullable=false,unique = true)
    private String name;

    @Column(name = "display_name", length=50, nullable=false)
    private String displayName;

    @Column(name = "guard_name", length=50, nullable=false)
    private String guardName = "web";

    @Column(name = "admin_access", nullable=false)
    private Boolean adminAccess;

    @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY)
    List<UserEntity> users;

    @ManyToMany(fetch = FetchType.LAZY)
    List<PermissionEntity> permissions;

    public void addPermission(PermissionEntity permission){
        this.permissions.add(permission);
    }
}
