package com.filip.springbootandjava8experiments.assemblers;

import com.filip.springbootandjava8experiments.models.User;
import com.filip.springbootandjava8experiments.utils.UserUtil;
import com.filip.springbootandjava8experiments.vo.CreateUserVO;
import com.filip.springbootandjava8experiments.vo.UpdateUserVO;
import com.filip.springbootandjava8experiments.vo.UserVO;
import org.springframework.stereotype.Component;

/**
 * @Component -(Spring Documentation) This is a general-purpose stereotype annotation indicating
 * that the class is spring component. This will be created a Singleton instance. That’s suitable
 * for this task as well.
 */
@Component
public class UserAssembler {

  /**
   * CreateUserVO convert to User.
   */
  public User toUser(CreateUserVO createUserVO) {
    User user = new User();
    user.setFirstName(createUserVO.getFirstName());
    user.setLastName(createUserVO.getLastName());
    user.setUsername(createUserVO.getUsername());
    return user;
  }


  /**
   * User to UserVO.
   */
  public UserVO toUserVO(User user) {
    UserVO userVO = new UserVO();
    userVO.setUserId(user.getId());
    userVO.setFullName(UserUtil.convertToFullName(user.getFirstName(), user.getLastName()));
    userVO.setUsername(user.getUsername());
    return userVO;

  }

  /**
   * UpdateUserVO to user.
   */
  public User toUser(UpdateUserVO updateUserVO) {
    User user = new User();
    user.setId(updateUserVO.getUserId());
    user.setFirstName(updateUserVO.getFirstName());
    user.setLastName(updateUserVO.getLastName());
    user.setUsername(updateUserVO.getUsername());
    return user;
  }
}
