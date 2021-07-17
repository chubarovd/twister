package com.twister.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sample")
public class SampleController {

  @GetMapping
  public String getSamplePage(Model model) {
    model.addAttribute("name", "Jopa");
    return "login/login_page";
  }
}
