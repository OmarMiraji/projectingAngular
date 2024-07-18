package com.ccm.bita.student.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Login" )

public class TourModel {
    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY)
    private Long id;
     @Column(nullable=false)
    private String Username;
    @Column(nullable=false)
private String Password;
@Column(nullable=false)

public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public String getUsername() {
    return Username;
}
public void setUsername(String username) {
    Username = username;
}
public String getPassword() {
    return Password;
}
public void setPassword(String password) {
    Password = password;
}


}
