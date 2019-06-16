package com.gmail.salahub.nikolay.hotel_app.service.converter.impl;

import com.gmail.salahub.nikolay.hotel_app.repository.model.Room;
import com.gmail.salahub.nikolay.hotel_app.service.converter.RoomConverter;
import com.gmail.salahub.nikolay.hotel_app.service.model.RoomDTO;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("roomConverter")
public class RoomConverterImpl implements RoomConverter {
    @Override
    public Room fromDTO(RoomDTO roomDTO) {
        Room room = new Room();
        room.setId(roomDTO.getId());
        room.setNumberOfBeds(Integer.valueOf(roomDTO.getNumberOfBeds()));
        room.setPrice(new BigDecimal(roomDTO.getPrice()));
        room.setTitle(roomDTO.getTitle());
        return room;
    }

    @Override
    public RoomDTO toDTO(Room room) {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setId(room.getId());
        roomDTO.setPrice(String.valueOf(room.getPrice()));
        roomDTO.setNumberOfBeds(String.valueOf(room.getNumberOfBeds()));
        roomDTO.setTitle(room.getTitle());
        return roomDTO;
    }
}
