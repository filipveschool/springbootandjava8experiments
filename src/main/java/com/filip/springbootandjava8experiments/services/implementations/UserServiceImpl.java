package com.filip.springbootandjava8experiments.services.implementations;

import com.filip.springbootandjava8experiments.exceptions.ResourceNotFoundException;
import com.filip.springbootandjava8experiments.models.User;
import com.filip.springbootandjava8experiments.repositories.UserRepository;
import com.filip.springbootandjava8experiments.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

  @Autowired
  private UserRepository userRepository;


  @Override
  public User getUserById(Long id) {
    //return userRepository.findById(id).orElseThrow( new IllegalArgumentException("User does not exist."));
    User user = userRepository.findById(id).orElseThrow(null);
    if (user == null) {
      throw new ResourceNotFoundException(id, "User not found");
    }

    return user;

  }

  @Override
  public User createUser(User user) {
    return userRepository.save(user);
  }

  @Override
  public User updateUser(User user) {
    return userRepository.save(user);
  }

  @Override
  public void deleteUser(Long id) {
    User user = getUserById(id);
    if (user != null) {
      userRepository.delete(user);
    }
  }
}
