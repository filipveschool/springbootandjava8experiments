package com.filip.springbootandjava8experiments.repositories;

import com.filip.springbootandjava8experiments.dtos.UserDto;
import com.filip.springbootandjava8experiments.models.User;
import java.util.Optional;
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

  Optional<User> findByUsername(String username);

  //Optional<User> findById(Long id);

}
