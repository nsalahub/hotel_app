package com.gmail.salahub.nikolay.hotel_app.service.model.order;

import com.gmail.salahub.nikolay.hotel_app.repository.model.User;
import com.gmail.salahub.nikolay.hotel_app.service.model.UserDTO;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

import static com.gmail.salahub.nikolay.hotel_app.constant.ApplicationConstant.DATE_TIME_FORMAT_STRING_VALUE;

public class CreateOrderDTO {

    private String id;
    @DateTimeFormat(pattern = DATE_TIME_FORMAT_STRING_VALUE)
    private Date startDate;
    @DateTimeFormat(pattern = DATE_TIME_FORMAT_STRING_VALUE)
    private Date endDate;
    private UserDTO userDTO;

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
