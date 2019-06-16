package com.gmail.salahub.nikolay.hotel_app.service.converter.impl;

import com.gmail.salahub.nikolay.hotel_app.repository.model.Order;
import com.gmail.salahub.nikolay.hotel_app.service.converter.OrderConverter;
import com.gmail.salahub.nikolay.hotel_app.service.converter.RoomConverter;
import com.gmail.salahub.nikolay.hotel_app.service.converter.UserConverter;
import com.gmail.salahub.nikolay.hotel_app.service.model.order.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("orderConverter")
public class OrderConverterImpl implements OrderConverter {

    private final UserConverter userConverter;
    private final RoomConverter roomConverter;

    @Autowired
    public OrderConverterImpl(UserConverter userConverter,
                              RoomConverter roomConverter){
        this.userConverter = userConverter;
        this.roomConverter = roomConverter;
    }

    @Override
    public Order fromDTO(OrderDTO orderDTO) {
        Order order = new Order();
        order.setId(orderDTO.getId());
        order.setRoom(roomConverter.fromDTO(orderDTO.getRoom()));
        order.setUser(userConverter.fromDTO(orderDTO.getUser()));
        order.setEndDate(orderDTO.getEndDate());
        order.setStartDate(orderDTO.getStartDate());
        return order;
    }

    @Override
    public OrderDTO toDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setRoom(roomConverter.toDTO(order.getRoom()));
        orderDTO.setUser(userConverter.toDTO(order.getUser()));
        orderDTO.setEndDate(order.getEndDate());
        orderDTO.setStartDate(order.getStartDate());
        return orderDTO;
    }
}
