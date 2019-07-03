package cn.jantd.exception.controller;

import cn.jantd.exception.exception.ControllerException;
import cn.jantd.exception.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

  @Autowired
  private TestService testService;

  @ResponseBody
  @RequestMapping("controller")
  public Object controller() throws ControllerException {
    throw new ControllerException("controller throw exception");
  }

  @ResponseBody
  @RequestMapping("service")
  public Object service() throws ControllerException{
    testService.throwServiceException(true);
    return "success";
  }

  @ResponseBody
  @RequestMapping("dao")
  public Object dao() throws ControllerException{
    testService.throwDaoException(true);
    return "success";
  }

}
