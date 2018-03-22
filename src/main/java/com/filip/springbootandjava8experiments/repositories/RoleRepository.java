package com.filip.springbootandjava8experiments.repositories;

import com.filip.springbootandjava8experiments.models.Role;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

  Set<Role> findAllByName(String name);

  void delete(Role role);

  Role findByName(String name);
}
