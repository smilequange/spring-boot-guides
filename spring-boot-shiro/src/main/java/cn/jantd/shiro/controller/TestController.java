package cn.jantd.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

  @ResponseBody
  @RequestMapping("/login")
  public Object login(String username, String password) {
    AuthenticationToken token = new UsernamePasswordToken(username, password);
    try {
      SecurityUtils.getSubject().login(token);
      return "success";
    } catch (AuthenticationException e) {
      e.printStackTrace();
    }
    return "failure";
  }

  @ResponseBody
  @RequestMapping("/hello")
  public Object hello() {
    return "hello world";
  }

}
