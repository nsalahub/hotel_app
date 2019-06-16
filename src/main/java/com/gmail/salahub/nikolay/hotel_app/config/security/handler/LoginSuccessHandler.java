package com.gmail.salahub.nikolay.hotel_app.config.security.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;

import static com.gmail.salahub.nikolay.hotel_app.constant.ApplicationConstant.ADMINISTRATOR_STRING_ROLE_VALUE;
import static com.gmail.salahub.nikolay.hotel_app.constant.ApplicationConstant.SHOW_HOTEL_ADMINISTRATOR_URL;
import static com.gmail.salahub.nikolay.hotel_app.constant.ApplicationConstant.SHOW_HOTEL_USER_URL;
import static com.gmail.salahub.nikolay.hotel_app.constant.ApplicationConstant.USER_STRING_ROLE_VALUE;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    private static final Logger logger = LoggerFactory.getLogger(LoginSuccessHandler.class);
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException {
        handle(httpServletRequest, httpServletResponse, authentication);
        clearAuthenticationAttribute(httpServletRequest);
    }

    private void handle(HttpServletRequest request,
                        HttpServletResponse response, Authentication authentication) throws IOException {
        String targetUrl = chooseTargetUrl(authentication);
        if (response.isCommitted()) {
            logger.info("response has ben committed");
            return;
        }
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    private String chooseTargetUrl(Authentication authentication) {
        Collection<? extends GrantedAuthority> authorities
                = authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equalsIgnoreCase(ADMINISTRATOR_STRING_ROLE_VALUE)) {
                logger.info(ADMINISTRATOR_STRING_ROLE_VALUE + " target url selected");
                return SHOW_HOTEL_ADMINISTRATOR_URL;
            } else if (grantedAuthority.getAuthority().equalsIgnoreCase(USER_STRING_ROLE_VALUE)) {
                logger.info(USER_STRING_ROLE_VALUE + " target url selected");
                return SHOW_HOTEL_USER_URL;
            }
        }
        throw new IllegalStateException();
    }

    private void clearAuthenticationAttribute(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
}
