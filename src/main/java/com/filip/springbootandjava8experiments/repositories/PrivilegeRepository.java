package com.filip.springbootandjava8experiments.repositories;

import com.filip.springbootandjava8experiments.models.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

  Privilege findByName(String name);

  void delete(Privilege privilege);

}
