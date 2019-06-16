package com.gmail.salahub.nikolay.hotel_app.repository;

import com.gmail.salahub.nikolay.hotel_app.repository.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String Email);
    User findById();
}
