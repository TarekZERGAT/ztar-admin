package com.ztardz.ztaradminapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "permissions",uniqueConstraints = @UniqueConstraint(columnNames = {"name","guard_name"}))
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionEntity extends AbstractEntity {

    /*@ManyToOne()
    @JoinColumn(name = "collection", referencedColumnName = "id")
    private CollectionEntity collection;
    collection VARCHAR(50) NOT NULL,*/

    @Column(name = "action", length=50, nullable=false)
    private String action;

    @Column(name = "name", length=50)
    private String name;

    @Column(name = "guard_name", length=50, nullable=false)
    private String guardName = "web";

    @ManyToMany(mappedBy = "permissions")
    Set<UserEntity> users = new HashSet<UserEntity>();

    @ManyToMany(mappedBy = "permissions")
    Set<RoleEntity> roles = new HashSet<RoleEntity>();
}
