package com.ztardz.ztaradminapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles",uniqueConstraints = @UniqueConstraint(columnNames = {"name","guard_name"}))
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntity extends AbstractEntity {
    @Column(name = "name", length=50, nullable=false)
    private String name;

    @Column(name = "display_name", length=50, nullable=false)
    private String displayName;

    @Column(name = "guard_name", length=50, nullable=false)
    private String guardName = "web";

    @Column(name = "admin_access", nullable=false)
    private Boolean adminAccess;

    @ManyToMany(mappedBy = "roles")
    Set<UserEntity> users = new HashSet<UserEntity>();

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "roles_permissions",
            joinColumns = { @JoinColumn(name = "role_id") },
            inverseJoinColumns = { @JoinColumn(name = "permission_id") }
    )
    Set<PermissionEntity> permissions = new HashSet<PermissionEntity>();
}
