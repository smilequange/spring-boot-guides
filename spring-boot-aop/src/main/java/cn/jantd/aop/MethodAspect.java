package cn.jantd.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodAspect {

  @Pointcut(value = "execution(public * cn.jantd.aop.controller.*.*())")
  public void webLog(){}

  @Around(value = "webLog()")
  public Object around(ProceedingJoinPoint pjp) throws Throwable {
    System.out.println("around before");
    Object result = pjp.proceed();
    System.out.println("around after");
    return result;
  }

  @Before(value = "webLog()")
  public void before(JoinPoint joinPoint){
    System.out.println("before");
  }

  @After(value = "webLog()")
  public void after(){
    System.out.println("after");

  }

  @AfterReturning(value = "webLog()")
  public void afterReturn(){
    System.out.println("afterReturn");

  }

  @AfterThrowing(value = "webLog()")
  public void afterThrowing(){
    System.out.println("afterThrowing");
  }

}
