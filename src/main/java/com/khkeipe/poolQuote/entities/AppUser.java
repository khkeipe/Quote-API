package com.khkeipe.poolQuote.entities;

import com.khkeipe.poolQuote.dtos.NewUser;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "app_users")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToOne(mappedBy = "user", fetch = FetchType.EAGER, orphanRemoval = true)
    private Address address;

    public AppUser() {
    }

    public AppUser(String username, String password) {
        this.email = username;
        this.password = password;
    }

    public AppUser(int id, String username, String password) {
        this.id = id;
        this.email = username;
        this.password = password;
    }

    public AppUser(NewUser newUser) {
        this.id = id;
        this.email = newUser.getEmail();
        this.password = newUser.getPassword();
        this.role = UserRole.USER;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return id == appUser.id &&
                Objects.equals(email, appUser.email) &&
                Objects.equals(password, appUser.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", email'" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
