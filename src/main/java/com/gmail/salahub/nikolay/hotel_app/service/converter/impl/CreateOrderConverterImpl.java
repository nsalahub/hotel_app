package com.gmail.salahub.nikolay.hotel_app.service.converter.impl;

import com.gmail.salahub.nikolay.hotel_app.repository.model.Order;
import com.gmail.salahub.nikolay.hotel_app.service.converter.CreateOrderConverter;
import com.gmail.salahub.nikolay.hotel_app.service.converter.UserConverter;
import com.gmail.salahub.nikolay.hotel_app.service.model.order.CreateOrderDTO;
import org.springframework.stereotype.Component;

@Component("createOrderConverter")
public class CreateOrderConverterImpl implements CreateOrderConverter {

    private final UserConverter userConverter;

    public CreateOrderConverterImpl(UserConverter userConverter){
        this.userConverter = userConverter;
    }

    @Override
    public Order fromDTO(CreateOrderDTO createOrderDTO) {
        Order order = new Order();
        order.setEndDate(createOrderDTO.getEndDate());
        order.setStartDate(createOrderDTO.getStartDate());
        order.setUser(userConverter.fromDTO(createOrderDTO.getUserDTO()));
        return order;
    }
}
