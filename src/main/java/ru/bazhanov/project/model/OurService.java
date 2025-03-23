package ru.bazhanov.project.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "services")
public class OurService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Integer id;

    @Column(name = "service_name")
    private String name;

    @Column(name = "service_price")
    private Double price;

    @Column(name = "service_duration")
    private  int duration;

    @Column(name = "service_deleted")
    private Boolean deleted;

    @ManyToMany(mappedBy = "ourServiceSet",cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    },fetch = FetchType.LAZY)
    private Set<Employee> employeeSet;

    @ManyToMany(mappedBy = "serviceSet",cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    },fetch = FetchType.EAGER)
    private Set<Client> clientSet;

    @OneToMany(mappedBy = "service")
    private Set<Order> orderSet;

    OurService(){}
    public OurService(String name, Double price, int duration){
        this.name = name;
        this.price = price;
        this.duration = duration;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }

    public Set<Client> getClientSet() {
        return clientSet;
    }

    public void setClientSet(Set<Client> clientSet) {
        this.clientSet = clientSet;
    }

    public Set<Order> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }
}
