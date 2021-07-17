package com.twister.backend.service;

import com.twister.backend.entity.User;

/**
 * Represents service for working with application users.
 */
public interface UserService {

  /**
   * Gets user id by its login and password. Useful on authorization request.
   *
   * @param login user login
   * @param password user password
   * @return user id of {@code null}
   */
  Long getUserId(String login, String password);

  /**
   * Gets {@link User} by user id.
   *
   * @param userId user id
   * @return {@link User} or {@code null}
   */
  User getUser(Long userId);
}
