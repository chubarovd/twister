package com.twister.backend.service.impl;

import com.twister.backend.entity.User;
import com.twister.backend.mybatis.mapper.UserMapper;
import com.twister.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link UserService} based on MyBatis mappers.
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserMapper userMapper;

  public Long getUserId(String login, String password) {
    return userMapper.checkUser(login, password);
  }

  public User getUser(Long id) {
    return userMapper.getUserById(id);
  }
}
