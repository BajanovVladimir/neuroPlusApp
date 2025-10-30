package ru.bazhanov.project.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
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

    @Column(name = "client_surname")
    private String surname;

    @Column(name = "client_date_of_birth")
    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "client")
    private Set<Contact> contactSet = new HashSet<>();

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

    public Client(String surname, String name, LocalDate dateOfBirth) {
        this.surname = surname;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.deleted = false;
    }
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
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
