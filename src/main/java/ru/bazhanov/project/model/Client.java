package ru.bazhanov.project.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
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

    @Column(name = "client_date_of_birth")
    private LocalDateTime dateOfBirth;

    @OneToMany(mappedBy = "client")
    private Set<Contact> contactSet;

    @Column(name = "client_deleted")
    private Boolean deleted;

    @ManyToMany( fetch = FetchType.EAGER)
    @JoinTable(
            name = "clients_services",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name="service_id", nullable = false)
    )
    private Set<OurService> serviceSet;

    @OneToMany(mappedBy = "client")
    private Set<Order> orderSet;

    Client(){}

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

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Set<Contact> getContactSet() {
        return contactSet;
    }

    public void setContactSet(Set<Contact> contactSet) {
        this.contactSet = contactSet;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Set<OurService> getServiceSet() {
        return serviceSet;
    }

    public void setServiceSet(Set<OurService> ourServiceSet) {
        this.serviceSet = ourServiceSet;
    }

    public Set<Order> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }
}
