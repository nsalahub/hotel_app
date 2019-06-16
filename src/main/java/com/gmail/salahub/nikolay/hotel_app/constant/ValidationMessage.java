package com.gmail.salahub.nikolay.hotel_app.constant;

public class ValidationMessage {
    private ValidationMessage(){}

    public static final String VALIDATION_EMPTY_TITLE_MESSAGE = "field title is empty";
    public static final String VALIDATION_EMPTY_NUMBER_OF_BEDS_MESSAGE = "field number of beds empty";
    public static final String VALIDATION_EMPTY_PRICE_MESSAGE = "field price is empty";

    public static final String VALIDATION_NUMBER_OF_BEDS_NOT_DIGIT_MESSAGE = "field number of digit has not digits";
    public static final String VALIDATION_PRICE_NOT_DIGIT_MESSAGE = "field price has not digits";

    public static final String VALIDATION_START_DATE_EXISTING_MESSAGE =
            "Sorry, you can't booking this room at this period";
    public static final String VALIDATION_END_DATE_EXISTING_MESSAGE =
            "Sorry, you can't booking this room at this period";
}
