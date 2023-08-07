package com.tave.forming.domain.jpa;

import com.tave.forming.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
     User findByEmail(String email);
     //User findByUserId(Long user_id);
     Optional<User> findById(Long userId);
}
