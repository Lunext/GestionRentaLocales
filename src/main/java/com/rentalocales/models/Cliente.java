package com.rentalocales.models;

import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id", unique = true)
    private Integer id;



    @Column(name = "clientName", nullable = false, length = 50)
    @Size(min =4, max = 50, message = "El minimo de letras para un nombre que se permite es 4 y maximo 50")

    private String clientName;
    @Column(name = "clientLastName", nullable = false, length = 50)
    private String clientLastName;
    @Column(name = "clientEmail", nullable = false, length = 50, unique = true)


    private String clientEmail;

    @ManyToOne()
    @JoinColumn(name = "local_id")
    private Local local;

    @ManyToOne()
    @JoinColumn(name = "horario_id")
    private Horario horario;

    public Cliente() {
    }

    public Cliente(Integer id, String clientName, String clientLastName, String clientEmail, Local local, Horario horario) {
        this.id = id;
        this.clientName = clientName;
        this.clientLastName = clientLastName;
        this.clientEmail = clientEmail;
        this.local = local;
        this.horario = horario;
    }

    public Cliente(String clientName, String clientLastName, String clientEmail, Local local, Horario horario) {
        this.clientName = clientName;
        this.clientLastName = clientLastName;
        this.clientEmail = clientEmail;
        this.local = local;
        this.horario = horario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", clientLastName='" + clientLastName + '\'' +
                ", clientEmail='" + clientEmail + '\'' +
                ", local=" + local +
                ", horario=" + horario +
                '}';
    }
}

