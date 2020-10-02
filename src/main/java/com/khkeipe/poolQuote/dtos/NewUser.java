package com.khkeipe.poolQuote.dtos;

import com.khkeipe.poolQuote.entities.Address;

import java.util.Objects;

public class NewUser {

    private String email;
    private String password;
    private String role;
    private int dealerRep;

    public NewUser() {
    }

    public NewUser(String email, String password, String role, int dealerRep) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.dealerRep = dealerRep;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getDealerRep() {
        return dealerRep;
    }

    public void setDealerRep(int dealerRep) {
        this.dealerRep = dealerRep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewUser newUser = (NewUser) o;
        return dealerRep == newUser.dealerRep &&
                Objects.equals(email, newUser.email) &&
                Objects.equals(password, newUser.password) &&
                Objects.equals(role, newUser.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, role, dealerRep);
    }

    @Override
    public String toString() {
        return "NewUser{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", dealerRep=" + dealerRep +
                '}';
    }

}
