package ru.college.chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.college.chat.domain.User;
import ru.college.chat.domain.dto.AddUserDto;
import ru.college.chat.repository.UserRepository;

import java.util.*;

@Service
public class UserService implements UserDetailsService {

  @Autowired
  private UserRepository userRepo;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepo.findUserByUsername(username);

    if (user == null) {
      throw new UsernameNotFoundException("User not found");
    }

    return user;
  }

  public boolean addUser(AddUserDto addUserDto) {
    User userFromDb = userRepo.findUserByUsername(addUserDto.getUsername());
    //System.out.println(userFromDb.getEmail());

    if (userFromDb != null) {
      return false;
    }

    User user = new User();
    user.setUsername(addUserDto.getUsername());
    user.setPassword(passwordEncoder.encode(addUserDto.getPassword()));
    user.setEmail(addUserDto.getEmail());


     userRepo.save(user);

    return true;
  }

  public List<User> findAll() {
    return userRepo.findAll();
  }

  public void saveUser(User user, String username, Map<String, String> form) {
    user.setUsername(username);
    userRepo.save(user);
  }

}
