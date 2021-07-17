package com.twister.backend.controller;

import com.twister.backend.dto.UserDTO;
import com.twister.backend.entity.User;
import com.twister.backend.exception.UserNotFoundException;
import com.twister.backend.service.UserService;
import java.util.Optional;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
@RequiredArgsConstructor
public class LoginController {

  private final UserService userService;

  @GetMapping
  public String getLoginPage() {
    return "login_page";
  }

  @PostMapping
  public String autorizationRequest(@Valid @ModelAttribute UserDTO user, Model model) {
    Optional<Long> userId = Optional
        .ofNullable(userService.getUserId(user.getLogin(), user.getPassword()));
    User userObj = userService.getUser(userId.orElseThrow(UserNotFoundException::new));
    model.addAttribute("first_name", userObj.getFirstName());
    model.addAttribute("last_name", userObj.getLastName());
    return "redirect:twister";
  }

  @ExceptionHandler(UserNotFoundException.class)
  public String getUserNotFoundMessage(Model model) {
    return "User does not exist!";
  }
}
