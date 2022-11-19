package com.ztardz.ztaradminapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "filiales")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilialeEntity extends AbstractEntity{
    @Column(name = "code", length=50, nullable=false,unique = true)
    private String code;

    @Column(name = "name", length=50, nullable=false,unique = true)
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    private List<UniteEntity> unites;
}
