package ru.bazhanov.project.services.dto;

public class ServiceDTO {
    private int id = 0;
    private String name;
    private String duration;
    private String price;

    public ServiceDTO(){}

    public ServiceDTO(String name, String duration, String price){
        this.name = name;
        this.duration = duration;
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
