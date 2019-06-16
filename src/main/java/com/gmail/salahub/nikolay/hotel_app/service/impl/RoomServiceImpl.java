package com.gmail.salahub.nikolay.hotel_app.service.impl;

import com.gmail.salahub.nikolay.hotel_app.repository.RoomRepository;
import com.gmail.salahub.nikolay.hotel_app.repository.model.Room;
import com.gmail.salahub.nikolay.hotel_app.service.RoomService;
import com.gmail.salahub.nikolay.hotel_app.service.converter.RoomConverter;
import com.gmail.salahub.nikolay.hotel_app.service.model.RoomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository;
    private RoomConverter roomConverter;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository, RoomConverter roomConverter) {
        this.roomConverter = roomConverter;
        this.roomRepository = roomRepository;
    }

    @Override
    @Transactional
    public List<RoomDTO> findAll() {
        List<Room> rooms = roomRepository.findAll();
        return rooms.stream().map(roomConverter::toDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void create(RoomDTO roomDTO) {
        Room room = roomConverter.fromDTO(roomDTO);
        roomRepository.save(room);
    }
}
