package com.filip.springbootandjava8experiments.services.interfaces;

import com.filip.springbootandjava8experiments.dtos.UserDto;
import com.filip.springbootandjava8experiments.models.User;
import java.util.List;
import java.util.Optional;

public interface IUserService {

  User getUserById(Long id);

  User createUser(User user);

  User updateUser(User user);

  void deleteUser(Long id);

  Optional<UserDto> findById(Long id);

  List<UserDto> findAll();

  UserDto registerNewUser(UserDto user);
}
