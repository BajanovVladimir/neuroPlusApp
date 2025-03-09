package ru.bazhanov.project.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "order_statuses")
public class OrderStatus {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private Integer id;

    @Column(name = "status_name")
    private String name;

    @OneToMany(mappedBy = "status")
    private Set<Order> orderSet;

    OrderStatus(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Order> getStatusSet() {
        return orderSet;
    }

    public void setStatusSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }
}
