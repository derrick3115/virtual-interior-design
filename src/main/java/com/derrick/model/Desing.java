package com.derrick.model;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Desing {
    @Id
    private String orderId;
    private String fName;
    private String lName;
    private String yard;
   @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderDate;
    private String picture;

    public Desing() {
    }

    public Desing(String orderId, String fName, String lName, String yard, Date orderDate, String picture) {
        this.orderId = orderId;
        this.fName = fName;
        this.lName = lName;
        this.yard = yard;
        this.orderDate = orderDate;
        this.picture = picture;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getYard() {
        return yard;
    }

    public void setYard(String yard) {
        this.yard = yard;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
