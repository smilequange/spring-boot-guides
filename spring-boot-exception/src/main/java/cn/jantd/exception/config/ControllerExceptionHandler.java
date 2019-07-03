package cn.jantd.exception.config;

import cn.jantd.exception.exception.ControllerException;
import cn.jantd.exception.exception.DaoException;
import cn.jantd.exception.exception.ServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ControllerExceptionHandler {

  @ResponseBody
  @ExceptionHandler(value = ControllerException.class)
  public Object exceptionHandler(ControllerException exception){
    if(exception instanceof DaoException){
      return "exception happen in dao";
    }else if(exception instanceof ServiceException){
      return "exception happen in service";
    }else{
      return "exception happen in controller";
    }
  }
}
