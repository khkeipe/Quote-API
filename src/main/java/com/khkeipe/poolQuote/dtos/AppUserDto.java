package com.khkeipe.poolQuote.dtos;

import com.khkeipe.poolQuote.entities.AppUser;

import java.util.Objects;

public class AppUserDto {

    private int id;
    private String email;
    private String role;

    public AppUserDto() {
    }

    public AppUserDto(String email, String role) {
        this.email = email;
        this.role = role;
    }

    public AppUserDto(int id, String email, String role) {
        this.id = id;
        this.email = email;
        this.role = role;
    }

    public AppUserDto(AppUser appUser) {
        this.id = appUser.getId();
        this.email = appUser.getEmail();
        this.role = appUser.getRole().toString();
    }

    public AppUserDto(Credentials creds) {
        this.email = creds.getEmail();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUserDto that = (AppUserDto) o;
        return id == that.id &&
                Objects.equals(email, that.email) &&
                Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, role);
    }

    @Override
    public String toString() {
        return "AppUserDto{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
