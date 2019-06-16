package com.gmail.salahub.nikolay.hotel_app.service.converter;

import com.gmail.salahub.nikolay.hotel_app.repository.model.Room;
import com.gmail.salahub.nikolay.hotel_app.service.model.RoomDTO;

public interface RoomConverter {
    Room fromDTO(RoomDTO roomDTO);

    RoomDTO toDTO(Room room);
}
