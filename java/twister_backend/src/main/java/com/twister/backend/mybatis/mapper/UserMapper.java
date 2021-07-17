package com.twister.backend.mybatis.mapper;

import com.twister.backend.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * MyBatis mapper which provides methods for working with users table.
 */
@Mapper
public interface UserMapper {

  @Select("SELECT u.user_id FROM users u WHERE u.login = #{login} AND u.password = #{password}")
  Long checkUser(
      @Param("login") String login,
      @Param("password") String password
  );

  @Select("SELECT u.user_id, u.login, u.first_name, u.last_name FROM users u WHERE u.user_id = #{id}")
  @Results({
      @Result(property = "id", column = "user_id"),
      @Result(property = "login", column = "login"),
      @Result(property = "firstName", column = "first_name"),
      @Result(property = "lastName", column = "last_name")
  })
  User getUserById(@Param("id") Long userId);
}
