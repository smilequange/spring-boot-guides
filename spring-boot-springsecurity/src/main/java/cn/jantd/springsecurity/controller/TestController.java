package cn.jantd.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

  @ResponseBody
  @RequestMapping("/test")
  public Object test(){
    return "root controller test request";
  }

}
