package com.gmail.salahub.nikolay.hotel_app.controller;

import com.gmail.salahub.nikolay.hotel_app.service.OrderService;
import com.gmail.salahub.nikolay.hotel_app.service.RoomService;
import com.gmail.salahub.nikolay.hotel_app.service.UserService;
import com.gmail.salahub.nikolay.hotel_app.service.model.RoomDTO;
import com.gmail.salahub.nikolay.hotel_app.service.model.UserDTO;
import com.gmail.salahub.nikolay.hotel_app.service.model.UserPrincipal;
import com.gmail.salahub.nikolay.hotel_app.service.model.order.CreateOrderDTO;
import com.gmail.salahub.nikolay.hotel_app.validator.OrderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.gmail.salahub.nikolay.hotel_app.constant.ApplicationConstant.REDIRECT_USER_ROOMS;

@Controller
@RequestMapping("/public")
public class UserController {

    private final RoomService roomService;
    private final OrderService orderService;
    private final UserService userService;
    private final OrderValidator orderValidator;

    @Autowired
    public UserController(RoomService roomService,
                          OrderService orderService,
                          UserService userService,
                          OrderValidator orderValidator) {
        this.orderValidator = orderValidator;
        this.userService = userService;
        this.orderService = orderService;
        this.roomService = roomService;
    }

    @GetMapping("/hotel/rooms")
    public String showUsers(Model model) {
        showRooms(model);
        return "roomsuser";
    }

    @PostMapping("/hotel/rooms/order")
    public String createOrder(@ModelAttribute(value = "createOrderDTO") CreateOrderDTO createOrderDTO,
                              BindingResult bindingResult, Model model) {
        orderValidator.validate(createOrderDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            showRooms(model);
            return "roomsuser";
        } else {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserDTO userDTO = userService.getByUsername(((UserPrincipal) userDetails).getUsername());
            createOrderDTO.setUserDTO(userDTO);
            orderService.create(createOrderDTO);
            return REDIRECT_USER_ROOMS;
        }
    }

    private void showRooms(Model model) {
        List<RoomDTO> roomDTOS = roomService.findAll();
        CreateOrderDTO createOrderDTO = new CreateOrderDTO();
        model.addAttribute("createOrderDTO", createOrderDTO);
        model.addAttribute("rooms", roomDTOS);
    }
}
