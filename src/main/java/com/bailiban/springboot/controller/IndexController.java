package com.bailiban.springboot.controller;

import com.bailiban.springboot.autoconfig.Hello;
import com.bailiban.springboot.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private Hello hello;

    @Autowired
    private IndexService indexService;


    @RequestMapping({"", "/", "/index"})
    public String index() {
        return hello.sayHello() + "中国";
    }

    @RequestMapping("add")
    public int add(int x, int y) {
        return indexService.add(x, y);
    }
}
