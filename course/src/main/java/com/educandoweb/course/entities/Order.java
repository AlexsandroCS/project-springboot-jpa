package com.educandoweb.course.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

    // Serializable serial number.
    private static final long serilVersionUID = 1L;

    // Atributes.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    // Associations.
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    // Constructors.
    public Order(){

    }
    public Order(Long id, Instant moment, User client) {
        this.id = id;
        this.moment = moment;
        this.client = client;
    }

    // Getters and Setters.
    public Long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }
    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public User getClient() {
        return client;
    }
    public void setClient(User client) {
        this.client = client;
    }

    // Equals and hashCode.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return id == order.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // toString.
    @Override
    public String toString() {
        return "ID: " + getId() + " - MOMENT: " + getMoment();
    }
}
