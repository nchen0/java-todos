package com.example.demo.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long userid;

    @Column(nullable=false)
    private String username;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "user")
    private Set<Todo> todo;

    public User() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getUserid() {
        return userid;
    }
}
