package ru.college.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.college.chat.domain.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
