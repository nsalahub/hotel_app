package com.gmail.salahub.nikolay.hotel_app.config.security.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.gmail.salahub.nikolay.hotel_app.constant.ApplicationConstant.URL_403_ERROR;

public class ApiAccessDeniedHandler implements AccessDeniedHandler {

    private static final String ILLEGAL_ACCESS_ERROR_MESSAGE = "{} tried to access protected resource: {}.";

    private static final Logger logger = LoggerFactory.getLogger(ApiAccessDeniedHandler.class);

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e)
            throws IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            logger.info(ILLEGAL_ACCESS_ERROR_MESSAGE, authentication.getName(), request.getRequestURI());
        }
        response.sendRedirect(request.getContextPath() + URL_403_ERROR);
    }
}