package ru.college.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.college.chat.domain.Addressee;
import ru.college.chat.domain.User;

public interface AddresseeRepository extends JpaRepository <Addressee, Long> {
    Addressee findAddresseeByAddresseeId(Long addresseeId);
}
