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

    //NEEDS ANNOTATIONS
    private Address address;

    public PoolDealer() {
    }

    public PoolDealer(String dealerName, String dealerCode, String phoneNumber, String email, Address address) {
        this.dealerName = dealerName;
        this.dealerCode = dealerCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public PoolDealer(int id, String dealerName, String dealerCode, String phoneNumber, String email, Address address) {
        this.id = id;
        this.dealerName = dealerName;
        this.dealerCode = dealerCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PoolDealer that = (PoolDealer) o;
        return id == that.id &&
                Objects.equals(dealerName, that.dealerName) &&
                Objects.equals(dealerCode, that.dealerCode) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(email, that.email) &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dealerName, dealerCode, phoneNumber, email, address);
    }

    @Override
    public String toString() {
        return "PoolDealer{" +
                "id=" + id +
                ", dealerName='" + dealerName + '\'' +
                ", dealerCode='" + dealerCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }

}
