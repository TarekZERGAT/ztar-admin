package com.ztardz.ztaradminapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "collections")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollectionEntity extends AbstractEntity{
    @Column(name = "collection", length=50, nullable=false, unique = true)
    private String collection;

    @Column(name = "type", length=50, nullable=false)
    private String type;

    @OneToMany(mappedBy = "collection")
    private Set<PermissionEntity> permissions;
}
