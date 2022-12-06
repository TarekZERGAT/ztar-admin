package com.ztardz.ztaradminapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "menu_items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItemEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", length=100, nullable=false, unique = true)
    private String title;

    @Column(name = "icon", length=100)
    private String icon;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent")
    private MenuItemEntity parent;

    @Column(name = "`order`", nullable=false)
    private Integer order;

    @Column(name = "url", length=100)
    private String url;

    @ManyToOne(fetch = FetchType.EAGER)
    private MenuEntity menu;

    @OneToOne(fetch = FetchType.EAGER)
    private PermissionEntity permission;

    @Column(name = "created_at", nullable=false)
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @ManyToOne()
    @JoinColumn(name = "created_by", nullable = false)
    private UserEntity createdBy;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @ManyToOne()
    @JoinColumn(name = "updated_by")
    private UserEntity updatedBy;

    @Column(name = "deleted_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;

    @ManyToOne()
    @JoinColumn(name = "deleted_by")
    private UserEntity deletedBy;

    @Column(name = "deleted_for", length=150)
    private String deletedFor;

    public MenuItemEntity(String title,MenuItemEntity parent, Integer order,MenuEntity menu,PermissionEntity permission){
        this.title = title;
        this.parent = parent;
        this.order = order;
        this.menu = menu;
        this.permission = permission;
    }
}
