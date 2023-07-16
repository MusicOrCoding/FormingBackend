package com.tave.forming.domain.jpa;

import com.tave.forming.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
     User findByEmail(String email);
     User findByUserId(Long user_id);
}
