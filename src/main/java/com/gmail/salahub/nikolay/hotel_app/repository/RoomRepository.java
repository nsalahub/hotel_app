package com.gmail.salahub.nikolay.hotel_app.repository;

import com.gmail.salahub.nikolay.hotel_app.repository.model.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepository extends MongoRepository<Room, String> {
}
