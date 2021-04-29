package com.example.oAuth2Demo.auth;

import com.example.oAuth2Demo.model.User;
import com.example.oAuth2Demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

/**
 * @author Chuanqi Shi
 * @date 2021/Apr/29
 */
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findById(s);
        if (user.isPresent()) {
            return new MyUserDetails(user.get());
        } else {
            throw new UsernameNotFoundException("cannot find user");
        }
    }
}
