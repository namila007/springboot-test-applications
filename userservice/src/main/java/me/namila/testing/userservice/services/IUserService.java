package me.namila.testing.userservice.services;

import me.namila.testing.userservice.models.User;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * The interface User service.
 */
public interface IUserService {

  /**
   * Create new user user.
   *
   * @param user the user
   * @return the user
   */
  User createNewUser(@RequestBody User user);
}
