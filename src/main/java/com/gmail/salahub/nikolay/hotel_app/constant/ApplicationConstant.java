package com.gmail.salahub.nikolay.hotel_app.constant;

public class ApplicationConstant {
    private ApplicationConstant(){
    }

    public static final String ADMINISTRATOR_STRING_ROLE_VALUE = "ADMINISTRATOR";
    public static final String USER_STRING_ROLE_VALUE = "USER";

    public static final String SHOW_HOTEL_ADMINISTRATOR_URL = "/private/hotel/rooms";
    public static final String SHOW_HOTEL_USER_URL = "/public/hotel/rooms";

    public static final String REDIRECT_ROOMS_URL = "redirect:/private/hotel/rooms";
    public static final String REDIRECT_USER_ROOMS = "redirect:/public/hotel/rooms";

    public static final String URL_403_ERROR = "/403";

    public static final String DATE_TIME_FORMAT_STRING_VALUE = "yyyy-MM-dd'T'HH:mm";
}
