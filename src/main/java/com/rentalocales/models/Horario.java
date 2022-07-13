package com.rentalocales.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="horarios")
public class Horario  {


    @Id
    @Column(unique = true, name = "horario_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;





    @Column(name = "openingTime", nullable = false )
    private String openingTime;


    @Column(name = "closingTime", nullable = false )
    private String closingTime;

    @Column(name = "givenDate", nullable = false)
    // @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date givenDate;


    @Column(name = "returnDate", nullable = false)
    // @Temporal(TemporalType.DATE)

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date returnDate;


    @ManyToOne()
    @JoinColumn(name = "local_id")
    private Local local;

    public Horario(){

    }

    public Horario(Integer id, String openingTime, String closingTime, Date givenDate, Date returnDate, Local local) {
        this.id = id;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.givenDate = givenDate;
        this.returnDate = returnDate;
        this.local = local;
    }

    public Horario(String openingTime, String closingTime, Date givenDate, Date returnDate, Local local) {
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.givenDate = givenDate;
        this.returnDate = returnDate;
        this.local = local;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public String getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }

    public Date getGivenDate() {
        return givenDate;
    }

    public void setGivenDate(Date givenDate) {
        this.givenDate = givenDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }
}
