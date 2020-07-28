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

    public PoolDealer() {
    }

    public PoolDealer(String dealerName, String dealerCode) {
        this.dealerName = dealerName;
        this.dealerCode = dealerCode;
    }

    public PoolDealer(int id, String dealerName, String dealerCode) {
        this.id = id;
        this.dealerName = dealerName;
        this.dealerCode = dealerCode;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PoolDealer that = (PoolDealer) o;
        return id == that.id &&
                Objects.equals(dealerName, that.dealerName) &&
                Objects.equals(dealerCode, that.dealerCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dealerName, dealerCode);
    }

    @Override
    public String toString() {
        return "PoolDealer{" +
                "id=" + id +
                ", dealerName='" + dealerName + '\'' +
                ", dealerCode='" + dealerCode + '\'' +
                '}';
    }
}
