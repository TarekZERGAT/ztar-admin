package com.ztardz.ztaradminapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "filiales")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilialeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code", length=50, nullable=false,unique = true)
    private String code;

    @Column(name = "name", length=50, nullable=false,unique = true)
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    private List<UniteEntity> unites;

    @ManyToMany(mappedBy = "filiales",fetch = FetchType.LAZY)
    List<UserEntity> users;

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
}
