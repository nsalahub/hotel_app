package com.gmail.salahub.nikolay.hotel_app.service;

import com.gmail.salahub.nikolay.hotel_app.service.model.order.CreateOrderDTO;
import com.gmail.salahub.nikolay.hotel_app.service.model.order.OrderDTO;

import java.util.List;

public interface OrderService {
    void create(CreateOrderDTO createOrderDTO);

    List<OrderDTO> getByRoomId(String roomId);
}
