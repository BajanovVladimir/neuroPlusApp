package ru.bazhanov.project.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "types_of_order")
public class TypeOfOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private Integer id;

    @Column(name = "type_name")
    private String name;

    @OneToMany(mappedBy = "type")
    Set<Order> orderSet;

    TypeOfOrder(){}

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

    public Set<Order> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }
}
