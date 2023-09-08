package com.example.questapp.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_name")
    private String user_name;

    @Column(name = "password")
    private String password;

    public User(){

    }
    public User(String user_name, String password) {
        this.user_name = user_name;
        this.password = password;
    }
}
