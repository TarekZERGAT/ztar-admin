package com.ztardz.ztaradminapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "fretcentres")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FretCentreEntity extends AbstractEntity{
    @Column(name = "code", length=50, nullable=false,unique = true)
    private String code;

    @Column(name = "name", length=50, nullable=false,unique = true)
    private String name;

    @ManyToOne()
    @JoinColumn(nullable = false)
    private UniteEntity unite;
}
