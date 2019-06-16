package com.gmail.salahub.nikolay.hotel_app.validator;

import com.gmail.salahub.nikolay.hotel_app.repository.model.Order;
import com.gmail.salahub.nikolay.hotel_app.service.OrderService;
import com.gmail.salahub.nikolay.hotel_app.service.model.order.CreateOrderDTO;
import com.gmail.salahub.nikolay.hotel_app.service.model.order.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

import static com.gmail.salahub.nikolay.hotel_app.constant.ValidationMessage.VALIDATION_END_DATE_EXISTING_MESSAGE;
import static com.gmail.salahub.nikolay.hotel_app.constant.ValidationMessage.VALIDATION_START_DATE_EXISTING_MESSAGE;

@Component("orderValidator")
public class OrderValidator implements Validator {

    private final OrderService orderService;

    @Autowired
    public OrderValidator(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Order.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        CreateOrderDTO verifiableOrderDTO = (CreateOrderDTO) o;
        List<OrderDTO> existingOrders = orderService.getByRoomId(verifiableOrderDTO.getId());

        for (OrderDTO order : existingOrders) {
            if (verifiableOrderDTO.getStartDate().after(order.getStartDate()) &
                    verifiableOrderDTO.getStartDate().before(order.getEndDate())) {
                errors.rejectValue("startDate", "", VALIDATION_START_DATE_EXISTING_MESSAGE);
            }
            if (verifiableOrderDTO.getEndDate().after(order.getStartDate()) &
                    verifiableOrderDTO.getEndDate().before(order.getEndDate())) {
                errors.rejectValue("endDate", "", VALIDATION_END_DATE_EXISTING_MESSAGE);
            }
        }
    }
}
