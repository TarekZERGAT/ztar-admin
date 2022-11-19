package com.ztardz.ztaradminapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    @ManyToOne()
    @JoinColumn(nullable = false)
    private FilialeEntity filiale;

    @OneToMany(fetch = FetchType.EAGER)
    private List<FretCentreEntity> fretCentres;
}
