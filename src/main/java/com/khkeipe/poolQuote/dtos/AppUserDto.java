package com.khkeipe.poolQuote.dtos;

import com.khkeipe.poolQuote.entities.Address;
import com.khkeipe.poolQuote.entities.AppUser;
import com.khkeipe.poolQuote.entities.UserRole;

import java.util.Objects;

public class AppUserDto {

    private int id;
    private String email;
    private String role;
    private String dealerName;

    public AppUserDto() {
    }

    public AppUserDto(String email, String role, String dealerName) {
        this.email = email;
        this.role = role;
        this.dealerName = dealerName;
    }

    public AppUserDto(int id, String email, String role, String dealerName) {
        this.id = id;
        this.email = email;
        this.role = role;
        this.dealerName = dealerName;
    }

    public AppUserDto(AppUser user){
        this.id = user.getId();
        this.email = user.getEmail();
        this.role = user.getRole().toString();
        this.dealerName = user.getDealerRep().getDealerName();
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUserDto that = (AppUserDto) o;
        return id == that.id &&
                Objects.equals(email, that.email) &&
                Objects.equals(role, that.role) &&
                Objects.equals(dealerName, that.dealerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, role, dealerName);
    }

    @Override
    public String toString() {
        return "AppUserDto{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", dealerName='" + dealerName + '\'' +
                '}';
    }

}
