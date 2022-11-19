package com.ztardz.ztaradminapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "activities")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityEntity extends AbstractEntity{
    @Column(name = "action", length=50, nullable=false)
    private String action;

    @ManyToOne()
    private CollectionEntity collection;

    @Column(name = "item_id")
    private Long itemId;
}
