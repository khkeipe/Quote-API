package com.khkeipe.poolQuote.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "quote")
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int orderNumber;

    @Column
    private String requestDate;

    @OneToOne(mappedBy = "quote", fetch = FetchType.EAGER, orphanRemoval = true)
    private Customer quoteCustomer;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private PoolDealer quoteDealer;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "")
    private List<Pool> quotePool;

    // TODO Add user relationship

    public Quote() {
    }

    public Quote(int id, int orderNumber, String requestDate, Customer quoteCustomer, PoolDealer quoteDealer) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.requestDate = requestDate;
        this.quoteCustomer = quoteCustomer;
        this.quoteDealer = quoteDealer;
    }

    public Quote(int orderNumber, String requestDate, Customer quoteCustomer, PoolDealer quoteDealer) {
        this.orderNumber = orderNumber;
        this.requestDate = requestDate;
        this.quoteCustomer = quoteCustomer;
        this.quoteDealer = quoteDealer;
    }

    public Quote(int orderNumber, String requestDate) {
        this.orderNumber = orderNumber;
        this.requestDate = requestDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public Customer getQuoteCustomer() {
        return quoteCustomer;
    }

    public void setQuoteCustomer(Customer quoteCustomer) {
        this.quoteCustomer = quoteCustomer;
    }

    public PoolDealer getQuoteDealer() {
        return quoteDealer;
    }

    public void setQuoteDealer(PoolDealer quoteDealer) {
        this.quoteDealer = quoteDealer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quote quote = (Quote) o;
        return id == quote.id &&
                orderNumber == quote.orderNumber &&
                Objects.equals(requestDate, quote.requestDate) &&
                Objects.equals(quoteCustomer, quote.quoteCustomer) &&
                Objects.equals(quoteDealer, quote.quoteDealer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderNumber, requestDate, quoteCustomer, quoteDealer);
    }

    @Override
    public String toString() {
        return "Quote{" +
                "id=" + id +
                ", orderNumber=" + orderNumber +
                ", requestDate='" + requestDate + '\'' +
                ", quoteCustomer=" + quoteCustomer +
                ", quoteDealer=" + quoteDealer +
                '}';
    }

}
