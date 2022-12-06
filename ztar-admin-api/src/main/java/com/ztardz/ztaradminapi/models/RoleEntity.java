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
public class RoleEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

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

    @Column(name = "created_at", nullable=false)
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @ManyToOne()
    @JoinColumn(name = "created_by", nullable = false)
    private UserEntity createdBy;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @ManyToOne()
    @JoinColumn(name = "updated_by")
    private UserEntity updatedBy;

    @Column(name = "deleted_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;

    @ManyToOne()
    @JoinColumn(name = "deleted_by")
    private UserEntity deletedBy;

    @Column(name = "deleted_for", length=150)
    private String deletedFor;

    public RoleEntity(String name,String displayName,Boolean adminAccess){
        this.name = name;
        this.displayName = displayName;
        this.adminAccess = adminAccess;
    }
}
