package com.rentalocales.models;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="locales")
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "local_id", unique = true)
    private Integer id;

    @Column(name = "localName", nullable = false, length = 50)

    private String localName;







    @Column(name = "cost", nullable = false)
    private Double cost;

    @Column(name = "city", nullable = false)

    private String city;

    @Column(name = "street", nullable = false)
    private String street;




    public Local() {

    }

    public Local(Integer id, String localName,   Double cost, String city, String street) {
        this.id = id;
        this.localName = localName;


        this.cost = cost;
        this.city = city;
        this.street = street;
    }

    public Local(String localName,  Double cost, String city, String street) {
        this.localName = localName;


        this.cost = cost;
        this.city = city;
        this.street = street;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }






    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Local{" +
                "id=" + id +
                ", localName='" + localName + '\'' +


                ", cost=" + cost +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
