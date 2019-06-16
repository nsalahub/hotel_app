package com.gmail.salahub.nikolay.hotel_app.service.converter;

import com.gmail.salahub.nikolay.hotel_app.repository.model.User;
import com.gmail.salahub.nikolay.hotel_app.service.model.UserDTO;

public interface UserConverter {
    User fromDTO(UserDTO userDTO);

    UserDTO toDTO(User user);
}
