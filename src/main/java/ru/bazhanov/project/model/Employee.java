package ru.bazhanov.project.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer id;

    @Column(name = "employee_name")
    private String name;

    @Column(name = "employee_deleted")
    private Boolean deleted = false;

    @ManyToMany( fetch = FetchType.EAGER)
    @JoinTable(
            name = "services_employees",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name="service_id", nullable = false)
    )
    private Set<OurService> ourServiceSet;

    @OneToMany(mappedBy = "employee")
    private Set<Order> orderSet;

    public Employee(){}

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

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Set<OurService> getServiceSet() {
        return ourServiceSet;
    }

    public void setServiceSet(Set<OurService> ourServiceSet) {
        this.ourServiceSet = ourServiceSet;
    }

    public Set<Order> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }
}
