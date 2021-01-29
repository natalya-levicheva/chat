package ru.college.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.college.chat.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Long> {
}
