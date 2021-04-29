package com.example.oAuth2Demo.config;

import com.example.oAuth2Demo.auth.MyUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author Chuanqi Shi
 * @date 2021/Apr/28
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // disable csrf token for POST requests
            .csrf().disable()
            // match requests with a filter chain
            .authorizeRequests()
                .antMatchers("/").permitAll()
                .anyRequest().hasRole("普通用户")
                .and()
            // enable basic auth
            .httpBasic()
                .and()
            .logout().permitAll();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        return new MyUserDetailService();
    }


}
