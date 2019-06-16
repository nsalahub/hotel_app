package com.gmail.salahub.nikolay.hotel_app.service;

import com.gmail.salahub.nikolay.hotel_app.service.model.UserDTO;

public interface UserService {
    UserDTO getByUsername(String username);
}
