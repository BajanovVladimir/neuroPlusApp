package ru.bazhanov.project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private int id;

    @Column(name = "contact_name")
    private String name;

    @Column(name = "contact_phone")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


    public Contact(){}
    public Contact(String name, String phone, Client client){
        this.name = name;
        this.phone = phone;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
