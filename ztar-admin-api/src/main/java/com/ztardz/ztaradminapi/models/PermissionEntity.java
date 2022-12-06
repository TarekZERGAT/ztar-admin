package com.ztardz.ztaradminapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "permissions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

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

    public PermissionEntity(String action,String name, CollectionEntity collection){
        this.action = action;
        this.name = name;
        this.collection = collection;
    }
}
