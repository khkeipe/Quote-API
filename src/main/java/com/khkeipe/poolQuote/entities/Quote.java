package com.khkeipe.poolQuote.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "quote")
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int orderNumber;

    private String requestDate;

    @OneToOne(mappedBy = "quote", fetch = FetchType.EAGER, orphanRemoval = true)
    private Customer quoteCustomer;

    //private PoolDealer quoteDealer;

    //private Pool quotePool;

    public Quote() {
    }

    public Quote(int id, int orderNumber, String requestDate, Customer quoteCustomer) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.requestDate = requestDate;
        this.quoteCustomer = quoteCustomer;
    }

}
