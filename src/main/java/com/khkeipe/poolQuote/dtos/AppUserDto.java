package com.khkeipe.poolQuote.dtos;

import com.khkeipe.poolQuote.entities.Address;
import com.khkeipe.poolQuote.entities.AppUser;
import com.khkeipe.poolQuote.entities.UserRole;

import java.util.Objects;

public class AppUserDto {

    private int id;
    private String email;
    private String role;
    private int dealerId;

    public AppUserDto() {
    }

    public AppUserDto(String email, String role, int dealerId) {
        this.email = email;
        this.role = role;
        this.dealerId = dealerId;
    }

    public AppUserDto(int id, String email, String role, int dealerId) {
        this.id = id;
        this.email = email;
        this.role = role;
        this.dealerId = dealerId;
    }

    public AppUserDto(AppUser user){
        this.id = user.getId();
        this.email = user.getEmail();
        this.role = user.getRole().toString();
        this.dealerId = user.getDealerRep().getId();
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

    public int getDealerID() {
        return dealerId;
    }

    public void setDealerId(int dealerId) {
        this.dealerId = dealerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUserDto that = (AppUserDto) o;
        return id == that.id &&
                Objects.equals(email, that.email) &&
                Objects.equals(role, that.role) &&
                Objects.equals(dealerId, that.dealerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, role, dealerId);
    }

    @Override
    public String toString() {
        return "AppUserDto{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", dealerName='" + dealerId + '\'' +
                '}';
    }

}
