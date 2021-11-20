package com.pharos.myposts.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String userName;

    @JsonIgnore
    private String userPassword;

    private String fullName;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;
}
