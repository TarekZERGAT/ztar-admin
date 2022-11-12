package com.ztardz.ztaradminapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "menu_items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItemEntity extends AbstractEntity{
    @Column(name = "title", length=100, nullable=false, unique = true)
    private String title;

    @Column(name = "icon", length=100)
    private String icon;

    @ManyToOne()
    @JoinColumn(name = "parent", referencedColumnName = "id")
    private MenuItemEntity parent;

    @Column(name = "`order`", nullable=false)
    private Integer order;

    @Column(name = "url", length=100)
    private String url;

    @ManyToOne()
    @JoinColumn(name = "menu", referencedColumnName = "id")
    private MenuEntity menu;

    @OneToOne()
    @JoinColumn(name = "permission", referencedColumnName = "id",nullable = false)
    private PermissionEntity permission;
}
