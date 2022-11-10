package com.ztardz.ztaradminapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends AbstractEntity {
    @Column(name = "first_name", length=50, nullable=false)
    private String firstName;

    @Column(name = "last_name", length=50, nullable=false)
    private String lastName;

    @Column(name = "username", length=50, nullable=false, unique = true)
    private String username;

    @Column(name = "email", length=50, nullable=false, unique = true)
    private String email;

    @Column(name = "password", length=100, nullable=false)
    private String password;

    @Column(name = "avatar", length=50)
    private String avatar;

    @Column(name = "theme", length=50)
    private String theme;

    @Column(name = "Status", length=50, nullable=false)
    private String Status;

    @Column(name = "last_access")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastAccess;

    @Column(name = "last_page", length=100)
    private String lastPage;
}
