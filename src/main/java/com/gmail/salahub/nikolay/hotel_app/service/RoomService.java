package com.gmail.salahub.nikolay.hotel_app.service;

import com.gmail.salahub.nikolay.hotel_app.repository.model.Room;
import com.gmail.salahub.nikolay.hotel_app.service.model.RoomDTO;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    List<RoomDTO> findAll();

    void create(RoomDTO roomDTO);

}
