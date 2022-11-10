package com.ztardz.ztaradminapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sessions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionEntity extends AbstractEntity{

    @Column(name = "token", length=100, nullable=false)
    private String token;

    @Column(name = "expires", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date expires;

    @Column(name = "ip", length=50)
    private String ip;

    @Column(name = "user_agent", length=50)
    private String userAgent;
}
