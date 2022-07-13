package com.rentalocales.models;

import javax.persistence.*;

@Entity
@Table(name = "tiposeventos")
public class TipoEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipoevento_id", unique = true)
    private Integer id;

    @Column(name = "eventType", nullable = false, length = 50 )
    private String eventType;

    public TipoEvento() {
    }

    public TipoEvento(String eventType) {
        this.eventType = eventType;
    }

    public TipoEvento(Integer id, String eventType) {
        this.id = id;
        this.eventType = eventType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    @Override
    public String toString() {
        return "TipoEvento{" +
                "id=" + id +
                ", eventType='" + eventType + '\'' +
                '}';
    }
}

