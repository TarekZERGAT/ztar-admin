package com.ztardz.ztaradminapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "activities")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "action", length=50, nullable=false)
    private String action;

    @ManyToOne()
    private CollectionEntity collection;

    @Column(name = "item_id")
    private Long itemId;

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

    public ActivityEntity(String action,CollectionEntity collection,Long itemId,UserEntity createdBy){
        this.action = action;
        this.collection = collection;
        this.itemId = itemId;
        this.createdBy = createdBy;
    }
}
