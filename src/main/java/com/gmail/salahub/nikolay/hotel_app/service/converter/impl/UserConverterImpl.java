package com.gmail.salahub.nikolay.hotel_app.service.converter.impl;

import com.gmail.salahub.nikolay.hotel_app.repository.model.User;
import com.gmail.salahub.nikolay.hotel_app.service.converter.UserConverter;
import com.gmail.salahub.nikolay.hotel_app.service.model.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserConverterImpl implements UserConverter {

    @Override
    public User fromDTO(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setRoleEnum(userDTO.getRoleEnum());
        return user;
    }

    @Override
    public UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setRoleEnum(user.getRoleEnum());
        return userDTO;
    }
}
