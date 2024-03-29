package com.twister.backend.entity;

import lombok.Data;

@Data
public class User {

  private Long id;
  private String login;
  private String firstName;
  private String lastName;
}
