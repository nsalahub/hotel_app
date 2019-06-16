package com.gmail.salahub.nikolay.hotel_app.service.converter;

import com.gmail.salahub.nikolay.hotel_app.repository.model.Order;
import com.gmail.salahub.nikolay.hotel_app.service.model.order.OrderDTO;

public interface OrderConverter {
    Order fromDTO (OrderDTO orderDTO);

    OrderDTO toDTO (Order order);
}
