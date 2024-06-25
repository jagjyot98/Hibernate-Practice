package com.hibernate.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "customer_info")
public class Customer {
    @Id
    private int cusId;
    private String cusName;
    @OneToOne
    private Address address;

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
