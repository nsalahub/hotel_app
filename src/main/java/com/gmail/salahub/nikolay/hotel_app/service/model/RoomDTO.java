package com.gmail.salahub.nikolay.hotel_app.service.model;

public class RoomDTO {
    private String id;
    private String title;
    private String numberOfBeds;
    private String price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(String numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
