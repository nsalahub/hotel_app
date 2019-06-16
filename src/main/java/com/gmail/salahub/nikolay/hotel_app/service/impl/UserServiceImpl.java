package com.gmail.salahub.nikolay.hotel_app.service.impl;

import com.gmail.salahub.nikolay.hotel_app.repository.UserRepository;
import com.gmail.salahub.nikolay.hotel_app.repository.model.User;
import com.gmail.salahub.nikolay.hotel_app.service.UserService;
import com.gmail.salahub.nikolay.hotel_app.service.converter.UserConverter;
import com.gmail.salahub.nikolay.hotel_app.service.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           UserConverter userConverter){
        this.userConverter = userConverter;
        this.userRepository = userRepository;

    }

    @Override
    @Transactional
    public UserDTO getByUsername(String username) {
        User user = userRepository.findByEmail(username);
        return userConverter.toDTO(user);
    }


}
