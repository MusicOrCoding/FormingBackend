package com.tave.forming.service;

import com.tave.forming.domain.jpa.UserRepository;
import com.tave.forming.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public User findById(Long id) {
        return userRepository.findByUserId(id);
    }
}
