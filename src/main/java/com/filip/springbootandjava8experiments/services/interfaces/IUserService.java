package com.filip.springbootandjava8experiments.services.interfaces;

import com.filip.springbootandjava8experiments.models.User;

public interface IUserService {

  User getUserById(Long id);

  User createUser(User user);

  User updateUser(User user);

  void deleteUser(Long id);
}
