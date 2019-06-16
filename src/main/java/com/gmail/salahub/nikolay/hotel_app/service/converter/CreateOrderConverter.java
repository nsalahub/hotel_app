package com.gmail.salahub.nikolay.hotel_app.service.converter;

import com.gmail.salahub.nikolay.hotel_app.repository.model.Order;
import com.gmail.salahub.nikolay.hotel_app.service.model.order.CreateOrderDTO;

public interface CreateOrderConverter {
    Order fromDTO (CreateOrderDTO createOrderDTO);
}
