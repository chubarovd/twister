package com.twister.backend.dto;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDTO {

  @NotNull
  private String login;

  @NotNull
  private String password;
}
