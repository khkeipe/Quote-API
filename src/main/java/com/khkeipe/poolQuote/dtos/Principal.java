package com.khkeipe.poolQuote.dtos;

import java.util.Objects;

public class Principal {

    private int id;
    private String email;
    private String Role;

    public Principal() {
    }

    public Principal(int id, String email, String role) {
        this.id = id;
        this.email = email;
        Role = role;
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
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Principal principal = (Principal) o;
        return id == principal.id &&
                Objects.equals(email, principal.email) &&
                Objects.equals(Role, principal.Role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, Role);
    }

    @Override
    public String toString() {
        return "Principal{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", Role='" + Role + '\'' +
                '}';
    }
}
