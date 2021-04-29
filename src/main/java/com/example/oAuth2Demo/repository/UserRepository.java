package com.example.oAuth2Demo.repository;

import com.example.oAuth2Demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Chuanqi Shi
 * @date 2021/Apr/29
 */
public interface UserRepository extends JpaRepository<User, String> {

}
