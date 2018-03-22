package com.filip.springbootandjava8experiments.services.implementations;

import com.filip.springbootandjava8experiments.models.User;
import com.filip.springbootandjava8experiments.repositories.UserRepository;
import java.util.Optional;
import javax.swing.text.html.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyCustomUserDetailsImpl implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> optionalUser = userRepository.findByUsername(username);
    optionalUser.orElseThrow(() -> new UsernameNotFoundException(username));
    return optionalUser.get();
  }
}
