package com.springboot.sandbox.es.springbootsandboxes.controller;

import com.springboot.sandbox.es.springbootsandboxes.service.ItemService;
import java.lang.reflect.Constructor;
import org.elasticsearch.client.RestClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

  private final ItemService itemService;
  public ItemController(ItemService itemService){
    this.itemService = itemService;
  }

  @RequestMapping(value = "/item/list", method = RequestMethod.GET)
  public String itemListController() {
    return "hello!!!";
  }

  @RequestMapping(value = "/item/lists", method = RequestMethod.GET)
  public String itemListsController() throws Exception{
//    Class<?> restClientClass = RestClient.class;
//    Constructor cons = restClientClass.getDeclaredConstructor(RestClient.class);
    return "hello!!!";
  }
}
