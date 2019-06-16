package com.gmail.salahub.nikolay.hotel_app.controller.rest;

import com.gmail.salahub.nikolay.hotel_app.service.RoomService;
import com.gmail.salahub.nikolay.hotel_app.service.model.RoomDTO;
import com.gmail.salahub.nikolay.hotel_app.validator.RoomValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomRestController {

    private final RoomService roomService;
    private final RoomValidator roomValidator;

    public RoomRestController(RoomService roomService,
                              RoomValidator roomValidator) {
        this.roomValidator = roomValidator;
        this.roomService = roomService;
    }

    @GetMapping("/api/private/rooms")
    public ResponseEntity<List<RoomDTO>> showRoomsForAdministrator() {
        List<RoomDTO> roomDTOS = roomService.findAll();
        return new ResponseEntity<>(roomDTOS, HttpStatus.OK);
    }

    @GetMapping("/api/public/rooms")
    public ResponseEntity<List<RoomDTO>> showRoomsForUser() {
        List<RoomDTO> roomDTOS = roomService.findAll();
        return new ResponseEntity<>(roomDTOS, HttpStatus.OK);
    }

    @PostMapping("/api/private/hotel/rooms/new")
    @SuppressWarnings("unchecked")
    public ResponseEntity saveRoom(
            @RequestBody RoomDTO roomDTO, BindingResult bindingResult
    ) {
        roomValidator.validate(roomDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        roomService.create(roomDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
