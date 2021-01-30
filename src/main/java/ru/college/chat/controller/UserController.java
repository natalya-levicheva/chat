package ru.college.chat.controller;

import org.springframework.web.bind.annotation.*;
import ru.college.chat.domain.User;
import ru.college.chat.domain.dto.AddUserDto;
import ru.college.chat.service.UserService;

@RestController
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
    this.userService = userService;
  }

    @PostMapping("/registration")
    @ResponseBody
    public boolean addUser(@RequestBody AddUserDto addUserDto){
      return userService.addUser(addUserDto);
    }

    @GetMapping("/")
    public String get(){
      return "win";
    }
}
