package com.filip.springbootandjava8experiments.repositories;

import com.filip.springbootandjava8experiments.models.User;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CrudRepository – provides basic crud functionalities.
 *
 * JpaRepository – provides JPA related functionalities such as persist, flush, batch delete, etc.
 *
 * PagingAndSortingRepository – provides additional functionalities such as paging and sorting.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  User findByUsername(String username);

  @Transactional
  void removeUserByUsername(String username);

}
