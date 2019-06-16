package com.gmail.salahub.nikolay.hotel_app.service.model.order;

import com.gmail.salahub.nikolay.hotel_app.service.model.RoomDTO;
import com.gmail.salahub.nikolay.hotel_app.service.model.UserDTO;

import java.util.Date;

public class OrderDTO {

    private String id;
    private Date startDate;
    private Date endDate;
    private UserDTO user;
    private RoomDTO room;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public RoomDTO getRoom() {
        return room;
    }

    public void setRoom(RoomDTO room) {
        this.room = room;
    }
}
