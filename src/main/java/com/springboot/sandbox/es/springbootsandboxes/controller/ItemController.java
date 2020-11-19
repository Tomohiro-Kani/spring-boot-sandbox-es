package com.springboot.sandbox.es.springbootsandboxes.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
  @RequestMapping(value = "/item/list", method = RequestMethod.GET)
  public String itemListController() {
    return "hello!!!";
  }
}
