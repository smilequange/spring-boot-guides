package com.jantd.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/person")
public class PersonController {




    @GetMapping("/get/{id}")
    public Person getPerson(@PathVariable Long id) {
        Person person = new Person();
        person.setAge(20);
        person.setName("peach");
        person.setId(id);
        return person;
    }

    @RequestMapping(value = "/add",produces = MediaType.TEXT_HTML_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody(required = false) Person person) {
        System.out.printf("11111");
    }
//    public void add(@RequestBody Person person) {
//        System.out.printf(person.getName());
//    }



    @GetMapping("/getHeader")
    public Map<String, String> getHeader(@RequestHeader("Host") String host,
                                         @RequestHeader("Accept") String accept,
                                         @RequestHeader("Accept-Language") String language,
                                         @RequestHeader("Accept-Encoding") String encoding,
                                         @RequestHeader(value = "Accept-Charset",defaultValue = "ISO-8859-1,utf-8") String charset,
                                         @RequestHeader(value = "Connection",defaultValue = "") String connection) {
        Map<String, String> headMap = new HashMap<>();
        headMap.put("Host", host);
        headMap.put("Accept", accept);
        headMap.put("Accept-Language", language);
        headMap.put("Accept-Encoding", encoding);
        headMap.put("Accept-Charset", charset);
        headMap.put("Connection:",connection);
        return headMap;
    }


}
