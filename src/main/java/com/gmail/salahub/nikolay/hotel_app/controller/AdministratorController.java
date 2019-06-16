package com.gmail.salahub.nikolay.hotel_app.controller;

import com.gmail.salahub.nikolay.hotel_app.service.RoomService;
import com.gmail.salahub.nikolay.hotel_app.service.model.RoomDTO;
import com.gmail.salahub.nikolay.hotel_app.validator.RoomValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.gmail.salahub.nikolay.hotel_app.constant.ApplicationConstant.REDIRECT_ROOMS_URL;

@Controller
@RequestMapping("/private")
public class AdministratorController {

    public static final Logger logger = LoggerFactory.getLogger(AdministratorController.class);

    private final RoomService roomService;
    private final RoomValidator roomValidator;

    @Autowired
    public AdministratorController(RoomService roomService,
                                   RoomValidator roomValidator) {
        this.roomValidator = roomValidator;
        this.roomService = roomService;
    }

    @GetMapping("/hotel/rooms")
    public String showUsers(Model model) {
        List<RoomDTO> roomDTOS = roomService.findAll();
        model.addAttribute("rooms", roomDTOS);
        return "roomsadministrator";
    }

    @GetMapping("/hotel/rooms/new")
    public String showAddRoomPage(Model model){
        RoomDTO roomDTO = new RoomDTO();
        model.addAttribute("room", roomDTO);
        return "newroom";
    }

    @PostMapping("/hotel/rooms/new")
    public String getUserFromAddUserPage(@ModelAttribute(value = "room") RoomDTO roomDTO,
                                         BindingResult bindingResult, Model model) {
        roomValidator.validate(roomDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("room", roomDTO);
            return "adduserpage";
        } else {
            roomService.create(roomDTO);
            logger.info(roomDTO.getPrice(), roomDTO.getTitle() + " success add");
            return REDIRECT_ROOMS_URL;
        }
    }
}
