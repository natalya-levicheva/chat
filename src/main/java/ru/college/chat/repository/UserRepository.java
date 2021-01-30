package ru.college.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.college.chat.domain.User;

public interface UserRepository extends JpaRepository <User, Long> {
  User findUserByUsername(String username);
}
