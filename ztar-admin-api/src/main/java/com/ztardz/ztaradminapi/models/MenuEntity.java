package com.ztardz.ztaradminapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "menus")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuEntity extends AbstractEntity{
    @Column(name = "name", length=50, nullable=false, unique = true)
    private String name;

    @OneToMany(mappedBy = "menu")
    private Set<MenuItemEntity> menuItems;
}
