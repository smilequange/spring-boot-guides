package cn.jantd.aop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

  @ResponseBody
  @RequestMapping("/hello")
  public Object hello(){
    return "hello world";
  }
  @ResponseBody
  @RequestMapping("/exception")
  public Object exception(){
    throw new RuntimeException();
  }

}
