package com.ztardz.ztaradminapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends AbstractEntity {
    @Column(name = "first_name", length=50, nullable=false)
    private String firstName;

    @Column(name = "last_name", length=50, nullable=false)
    private String lastName;

    @Column(name = "username", length=50, nullable=false, unique = true)
    private String username;

    @Column(name = "email", length=50, nullable=false, unique = true)
    private String email;

    @Column(name = "password", length=100, nullable=false)
    private String password;

    @Column(name = "avatar", length=50)
    private String avatar;

    @Column(name = "theme", length=50)
    private String theme;

    @Column(name = "Status", length=50, nullable=false)
    private String Status = "active";

    @Column(name = "last_access")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastAccess;

    @Column(name = "last_page", length=100)
    private String lastPage;

    @ManyToMany(fetch = FetchType.LAZY)
    List<RoleEntity> roles;

    @ManyToMany(fetch = FetchType.LAZY)
    List<PermissionEntity> permissions;

    public void addRole(RoleEntity role){
        this.roles.add(role);
    }

    public void addPermission(PermissionEntity permission){
        this.permissions.add(permission);
    }

    @OneToMany(mappedBy="createdBy",fetch = FetchType.LAZY)
    private List<SessionEntity> sessions;

    @OneToMany(mappedBy="createdBy",fetch = FetchType.LAZY)
    private List<ActivityEntity> activities;

    @ManyToMany(fetch = FetchType.LAZY)
    List<FilialeEntity> filiales;

    @ManyToMany(fetch = FetchType.LAZY)
    List<UniteEntity> unites;

    @ManyToMany(fetch = FetchType.LAZY)
    List<FretCentreEntity> fretCentres;
}
