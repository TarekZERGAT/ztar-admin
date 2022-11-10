package com.ztardz.ztaradminapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

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
}
