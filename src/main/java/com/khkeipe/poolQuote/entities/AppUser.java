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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private PoolDealer dealerRep;

//    @OneToOne(mappedBy = "user", fetch = FetchType.EAGER, orphanRemoval = true)
//    private Address address;

    public AppUser() {
    }

    public AppUser(String email, String password, UserRole role, PoolDealer dealerRep) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.dealerRep = dealerRep;
    }

    public AppUser(int id, String email, String password, UserRole role, PoolDealer dealerRep) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.dealerRep = dealerRep;
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

    public void setEmail(String email) {
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

    public PoolDealer getDealerRep() {
        return dealerRep;
    }

    public void setDealerRep(PoolDealer dealerRep) {
        this.dealerRep = dealerRep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return id == appUser.id &&
                Objects.equals(email, appUser.email) &&
                Objects.equals(password, appUser.password) &&
                role == appUser.role &&
                Objects.equals(dealerRep, appUser.dealerRep);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, role, dealerRep);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", dealerRep=" + dealerRep +
                '}';
    }

}
