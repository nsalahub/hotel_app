package com.gmail.salahub.nikolay.hotel_app.service.impl;

import com.gmail.salahub.nikolay.hotel_app.repository.OrderRepository;
import com.gmail.salahub.nikolay.hotel_app.repository.RoomRepository;
import com.gmail.salahub.nikolay.hotel_app.repository.model.Order;
import com.gmail.salahub.nikolay.hotel_app.repository.model.Room;
import com.gmail.salahub.nikolay.hotel_app.service.OrderService;
import com.gmail.salahub.nikolay.hotel_app.service.converter.CreateOrderConverter;
import com.gmail.salahub.nikolay.hotel_app.service.converter.OrderConverter;
import com.gmail.salahub.nikolay.hotel_app.service.model.order.CreateOrderDTO;
import com.gmail.salahub.nikolay.hotel_app.service.model.order.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final RoomRepository roomRepository;
    private final OrderRepository orderRepository;
    private final CreateOrderConverter createOrderConverter;
    private final OrderConverter orderConverter;

    @Autowired
    public OrderServiceImpl(RoomRepository roomRepository,
                            OrderRepository orderRepository,
                            CreateOrderConverter createOrderConverter,
                            OrderConverter orderConverter) {
        this.orderConverter = orderConverter;
        this.createOrderConverter = createOrderConverter;
        this.roomRepository = roomRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    @Transactional
    public void create(CreateOrderDTO createOrderDTO) {
        Optional<Room> optional = roomRepository.findById(createOrderDTO.getId());
        Order order = createOrderConverter.fromDTO(createOrderDTO);
        order.setRoom(optional.get());
        orderRepository.save(order);
    }

    @Override
    @Transactional
    public List<OrderDTO> getByRoomId(String roomId) {
        Optional<Room> optional = roomRepository.findById(roomId);
        List<Order> orders = orderRepository.findAllByRoom(optional.get());
        return orders.stream()
                .map(orderConverter::toDTO)
                .collect(Collectors.toList());
    }
}
