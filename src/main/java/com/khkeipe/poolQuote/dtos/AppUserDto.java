package com.khkeipe.poolQuote.dtos;

import com.khkeipe.poolQuote.entities.AppUser;

import java.util.Objects;

public class AppUserDto {

    private int id;
    private String username;
    private String role;

    public AppUserDto() {
    }

    public AppUserDto(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public AppUserDto(int id, String username, String role) {
        this.id = id;
        this.username = username;
        this.role = role;
    }

    public AppUserDto(AppUser appUser) {
        this.id = appUser.getId();
        this.username = appUser.getUsername();
        this.role = appUser.getRole().toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
                Objects.equals(username, that.username) &&
                Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, role);
    }

    @Override
    public String toString() {
        return "AppUserDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
