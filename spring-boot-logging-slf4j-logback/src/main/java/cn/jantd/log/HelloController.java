package cn.jantd.log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
public class HelloController {

    @GetMapping("/")
    public String hello(Model model) {
        List<Integer> data = Arrays.asList(1, 2, 3, 4, 5);
        log.info("Hello from Logback {}", data);
        model.addAttribute("num", data);
        return "index";
    }

}
