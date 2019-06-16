package com.gmail.salahub.nikolay.hotel_app.repository;

import com.gmail.salahub.nikolay.hotel_app.repository.model.Order;
import com.gmail.salahub.nikolay.hotel_app.repository.model.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {

    List<Order> findAllByRoom(Room room);
}
