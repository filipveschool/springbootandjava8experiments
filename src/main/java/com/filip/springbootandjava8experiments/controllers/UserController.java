package com.filip.springbootandjava8experiments.controllers;

import com.filip.springbootandjava8experiments.assemblers.UserAssembler;
import com.filip.springbootandjava8experiments.models.User;
import com.filip.springbootandjava8experiments.services.interfaces.IUserService;
import com.filip.springbootandjava8experiments.vo.CreateUserVO;
import com.filip.springbootandjava8experiments.vo.UpdateUserVO;
import com.filip.springbootandjava8experiments.vo.UserVO;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

  @Autowired
  private IUserService userService;

  @Autowired
  private UserAssembler userAssembler;

  @GetMapping(value = "/{id}")
  @ResponseStatus(HttpStatus.OK)
  public UserVO getUser(@PathVariable("id") Long id) {
    return userAssembler.toUserVO(userService.getUserById(id));
  }

  @PostMapping
  public UserVO createUser(@Valid @RequestBody CreateUserVO userVO) {
    //convert to User
    User user = userAssembler.toUser(userVO);
    //save User
    User savedUser = userService.createUser(user);
    //convert to UserVO
    return userAssembler.toUserVO(savedUser);
  }

  @PutMapping
  public UserVO updateUser(@RequestBody UpdateUserVO updateUserVO) {
    //convert to User
    User user = userAssembler.toUser(updateUserVO);
    //update User
    User updatedUser = userService.updateUser(user);
    //convert to UserVO
    return userAssembler.toUserVO(user);
  }

  @DeleteMapping(value = "/{id}")
  public void delete(@PathVariable("id") Long id) {
    userService.deleteUser(id);
  }

}
