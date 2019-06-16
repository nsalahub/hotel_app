package com.gmail.salahub.nikolay.hotel_app.controller.rest;

import com.gmail.salahub.nikolay.hotel_app.service.OrderService;
import com.gmail.salahub.nikolay.hotel_app.service.model.order.CreateOrderDTO;
import com.gmail.salahub.nikolay.hotel_app.validator.OrderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRestController {

    private final OrderService orderService;
    private final OrderValidator orderValidator;

    @Autowired
    public OrderRestController(OrderService orderService,
                               OrderValidator orderValidator){
        this.orderValidator = orderValidator;
        this.orderService = orderService;
    }

    @PostMapping("/api/private/hotel/rooms/new")
    @SuppressWarnings("unchecked")
    public ResponseEntity saveRoom(
            @RequestBody CreateOrderDTO createOrderDTO, BindingResult bindingResult
    ) {
        orderValidator.validate(createOrderDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        orderService.create(createOrderDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
