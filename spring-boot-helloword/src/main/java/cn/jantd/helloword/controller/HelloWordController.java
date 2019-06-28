package cn.jantd.helloword.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author 圈哥
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/6/26
 */
@RestController
@RequestMapping("hello")
public class HelloWordController {

    @GetMapping("/say")
    public  String say(){
        return  "hello word Spring Boot";
    }


}
