package com.bailiban.springboot.autoconfig;

import lombok.Setter;

public class Hello {

    @Setter
    private String msg;

    public String sayHello() {
        return "Hello " + msg + "!";
    }
}
