package com.khkeipe.poolQuote.dtos;

import com.khkeipe.poolQuote.entities.Address;

import java.util.Objects;

public class NewUser {

    private String email;
    private String password;
    private String passwordVerification;

    public NewUser() {
    }

    public NewUser(String email, String password, String passwordVerification) {
        this.email = email;
        this.password = password;
        this.passwordVerification = passwordVerification;
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

    public String getPasswordVerification() {
        return passwordVerification;
    }

    public void setPasswordVerification(String passwordVerification) {
        this.passwordVerification = passwordVerification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewUser newUser = (NewUser) o;
        return Objects.equals(email, newUser.email) &&
                Objects.equals(password, newUser.password) &&
                Objects.equals(passwordVerification, newUser.passwordVerification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, passwordVerification);
    }

    @Override
    public String toString() {
        return "NewUser{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", passwordVerification='" + passwordVerification + '\'' +
                '}';
    }
}
