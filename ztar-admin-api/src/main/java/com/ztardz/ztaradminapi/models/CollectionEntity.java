package com.ztardz.ztaradminapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "collections")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollectionEntity extends AbstractEntity{
    @Column(name = "name", length=50, nullable=false, unique = true)
    private String name;

    @Column(name = "type", length=50, nullable=false)
    private String type;

    @OneToMany(mappedBy = "collection",fetch = FetchType.LAZY)
    private List<PermissionEntity> permissions;

    /*@OneToMany(mappedBy = "collection")
    private Set<ActivityEntity> activities;*/
}
