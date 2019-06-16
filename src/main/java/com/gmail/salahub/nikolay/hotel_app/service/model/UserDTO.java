package com.gmail.salahub.nikolay.hotel_app.service.model;

import com.gmail.salahub.nikolay.hotel_app.repository.model.RoleEnum;

public class UserDTO {
    private String id;
    private String email;
    private String password;
    private RoleEnum roleEnum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleEnum getRoleEnum() {
        return roleEnum;
    }

    public void setRoleEnum(RoleEnum roleEnum) {
        this.roleEnum = roleEnum;
    }
}
