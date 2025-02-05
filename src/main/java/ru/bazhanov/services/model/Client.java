package ru.bazhanov.services.model;

import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Integer id;

    @Column(name = "client_name")
    private String name;

    @Column(name = "client_phone")
    private String phone;

    @Column(name = "client_deleted")
    private Boolean deleted;

    @ManyToMany( fetch = FetchType.EAGER)
    @JoinTable(
            name = "clients_services",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name="service_id", nullable = false)
    )
    private Set<Service> serviceSet;

    @OneToMany(mappedBy = "client")
    private Set<Order> orderSet;

    Client(){};

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Set<Service> getServiceSet() {
        return serviceSet;
    }

    public void setServiceSet(Set<Service> serviceSet) {
        this.serviceSet = serviceSet;
    }

    public Set<Order> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }
}
