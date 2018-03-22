package com.filip.springbootandjava8experiments.services.implementations;

import com.filip.springbootandjava8experiments.dtos.UserDto;
import com.filip.springbootandjava8experiments.exceptions.ResourceNotFoundException;
import com.filip.springbootandjava8experiments.exceptions.UsernameExistsException;
import com.filip.springbootandjava8experiments.models.User;
import com.filip.springbootandjava8experiments.repositories.RoleRepository;
import com.filip.springbootandjava8experiments.repositories.UserRepository;
import com.filip.springbootandjava8experiments.services.interfaces.IUserService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  @Override
  public User getUserById(Long id) {
    //return userRepository.findById(id).orElseThrow( new IllegalArgumentException("User does not exist."));
    return userRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException(id, "User not found"));
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

  @Override
  public Optional<UserDto> findById(Long id) {
    Optional<User> entity = userRepository.findById(id);
    Optional<UserDto> user = entity.map(this::convertEntityToDto);
    user.orElseThrow(() -> new ResourceNotFoundException("User not found"));
    return user;
  }

  @Override
  public List<UserDto> findAll() {
    return userRepository.findAll()
        .stream()
        .map(this::convertEntityToDto)
        .collect(Collectors.toList());
  }

  @Override
  public UserDto registerNewUser(UserDto user) {
    if (userRepository.findByUsername(user.getUsername()).isPresent()) {
      throw new UsernameExistsException("Username already exists, please choose another one.");
    }
    return convertEntityToDto(userRepository.save(convertDtoToEntity(user)));
  }

  private User convertDtoToEntity(UserDto userDto) {
    User user = new User();
    user.setUsername(userDto.getUsername());
    user.setPassword(passwordEncoder.encode(userDto.getPassword()));
    user.setActive(true);
    user.setRoles(roleRepository.findAllByName("User"));
    return user;
  }

  private UserDto convertEntityToDto(User user) {
    UserDto userDto = new UserDto();
    userDto.setId(user.getId());
    userDto.setUsername(user.getUsername());
    userDto.setActive(user.isActive());
    userDto.setRoles(user.getRoles());
    return userDto;
  }
}
