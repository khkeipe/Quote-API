package com.khkeipe.poolQuote.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dealers")
public class PoolDealer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String dealerName;

    @Column
    private String dealerCode;

    @Column
    private String phoneNumber;

    @Column
    private String email;

    @Column
    private String streetName;

    @Column
    private String cityName;

    @Column
    private String stateName;

    @Column
    private int zipCode;

    public PoolDealer() {
    }

    public PoolDealer(String dealerName, String dealerCode, String phoneNumber, String email, String streetName, String cityName, String stateName, int zipCode) {
        this.dealerName = dealerName;
        this.dealerCode = dealerCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.streetName = streetName;
        this.cityName = cityName;
        this.stateName = stateName;
        this.zipCode = zipCode;
    }

    public PoolDealer(int id, String dealerName, String dealerCode, String phoneNumber, String email, String streetName, String cityName, String stateName, int zipCode) {
        this.id = id;
        this.dealerName = dealerName;
        this.dealerCode = dealerCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.streetName = streetName;
        this.cityName = cityName;
        this.stateName = stateName;
        this.zipCode = zipCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getDealerCode() {
        return dealerCode;
    }

    public void setDealerCode(String dealerCode) {
        this.dealerCode = dealerCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PoolDealer that = (PoolDealer) o;
        return id == that.id &&
                zipCode == that.zipCode &&
                Objects.equals(dealerName, that.dealerName) &&
                Objects.equals(dealerCode, that.dealerCode) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(email, that.email) &&
                Objects.equals(streetName, that.streetName) &&
                Objects.equals(cityName, that.cityName) &&
                Objects.equals(stateName, that.stateName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dealerName, dealerCode, phoneNumber, email, streetName, cityName, stateName, zipCode);
    }

    @Override
    public String toString() {
        return "PoolDealer{" +
                "id=" + id +
                ", dealerName='" + dealerName + '\'' +
                ", dealerCode='" + dealerCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", streetName='" + streetName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", stateName='" + stateName + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }

}
