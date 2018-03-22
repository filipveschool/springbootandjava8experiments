package com.filip.springbootandjava8experiments.security;

import com.filip.springbootandjava8experiments.models.Privilege;
import com.filip.springbootandjava8experiments.models.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserPrincipal implements UserDetails {

  private static final long serialVersionUID = 1L;

  private final User user;

  public MyUserPrincipal(User user) {
    this.user = user;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    for (final Privilege privilege : user.getPrivileges()) {
      authorities.add(new SimpleGrantedAuthority(privilege.getName()));
    }
    return authorities;
  }

  @Override
  public String getPassword() {
    return user.getPassword();
  }

  @Override
  public String getUsername() {
    return user.getUsername();
  }

  @Override
  public boolean isAccountNonExpired() {
    return false;
  }

  @Override
  public boolean isAccountNonLocked() {
    return false;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return false;
  }

  @Override
  public boolean isEnabled() {
    return user.isActive();
  }
}
