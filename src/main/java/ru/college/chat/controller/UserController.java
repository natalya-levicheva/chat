package ru.college.chat.controller;

import org.springframework.web.bind.annotation.RestController;
import ru.college.chat.service.UserService;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
    this.userService = userService;
  }
}
