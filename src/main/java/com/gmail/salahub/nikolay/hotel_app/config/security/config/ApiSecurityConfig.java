package com.gmail.salahub.nikolay.hotel_app.config.security.config;

import com.gmail.salahub.nikolay.hotel_app.config.security.handler.ApiAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import static com.gmail.salahub.nikolay.hotel_app.repository.model.RoleEnum.ADMINISTRATOR;
import static com.gmail.salahub.nikolay.hotel_app.repository.model.RoleEnum.USER;

@Configuration
@Order(1)
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApiSecurityConfig(@Qualifier("appUserDetailsService") UserDetailsService userDetailsService,
                             PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/api/private/**")
                .authorizeRequests()
                .anyRequest()
                .hasAuthority(ADMINISTRATOR.name())
                .and()
                .antMatcher("/api/public/**")
                .authorizeRequests()
                .anyRequest()
                .hasAuthority(USER.name())
                .and()
                .httpBasic()
                .and()
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler())
                .and()
                .csrf()
                .disable();
    }

    @Bean("apiAccessDeniedHandler")
    public AccessDeniedHandler accessDeniedHandler() {
        return new ApiAccessDeniedHandler();
    }
}