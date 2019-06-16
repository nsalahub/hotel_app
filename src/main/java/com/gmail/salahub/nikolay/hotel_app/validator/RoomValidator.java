package com.gmail.salahub.nikolay.hotel_app.validator;

import com.gmail.salahub.nikolay.hotel_app.service.model.RoomDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

import static com.gmail.salahub.nikolay.hotel_app.constant.ValidationMessage.VALIDATION_EMPTY_NUMBER_OF_BEDS_MESSAGE;
import static com.gmail.salahub.nikolay.hotel_app.constant.ValidationMessage.VALIDATION_EMPTY_PRICE_MESSAGE;
import static com.gmail.salahub.nikolay.hotel_app.constant.ValidationMessage.VALIDATION_EMPTY_TITLE_MESSAGE;
import static com.gmail.salahub.nikolay.hotel_app.constant.ValidationMessage.VALIDATION_NUMBER_OF_BEDS_NOT_DIGIT_MESSAGE;
import static com.gmail.salahub.nikolay.hotel_app.constant.ValidationMessage.VALIDATION_PRICE_NOT_DIGIT_MESSAGE;

@Component("roomValidator")
public class RoomValidator implements Validator {

    private static final String ONLY_DIGIT_REGEX = "[0-9]" ;

    @Override
    public boolean supports(Class<?> aClass) {
        return RoomDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "title", "", VALIDATION_EMPTY_TITLE_MESSAGE);
        ValidationUtils.rejectIfEmpty(errors, "numberOfBeds", "", VALIDATION_EMPTY_NUMBER_OF_BEDS_MESSAGE);
        ValidationUtils.rejectIfEmpty(errors, "price", "", VALIDATION_EMPTY_PRICE_MESSAGE);

        RoomDTO roomDTO = (RoomDTO) o;

        Pattern pattern;

        pattern = Pattern.compile(ONLY_DIGIT_REGEX,
                Pattern.CASE_INSENSITIVE);
        if (!(pattern.matcher(roomDTO.getNumberOfBeds()).matches())) {
            errors.rejectValue("numberOfBeds", "", VALIDATION_NUMBER_OF_BEDS_NOT_DIGIT_MESSAGE);
        }

        pattern = Pattern.compile(ONLY_DIGIT_REGEX,
                Pattern.CASE_INSENSITIVE);
        if (!(pattern.matcher(roomDTO.getPrice()).matches())) {
            errors.rejectValue("price", "", VALIDATION_PRICE_NOT_DIGIT_MESSAGE);
        }
    }
}
