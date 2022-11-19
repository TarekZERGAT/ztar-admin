package com.ztardz.ztaradminapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "unites")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UniteEntity extends AbstractEntity{
    @Column(name = "code", length=50, nullable=false,unique = true)
    private String code;

    @Column(name = "name", length=50, nullable=false,unique = true)
    private String name;
}
