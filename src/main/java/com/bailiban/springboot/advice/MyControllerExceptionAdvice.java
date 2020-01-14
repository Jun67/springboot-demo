package com.bailiban.springboot.advice;

import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyControllerExceptionAdvice {

    @ExceptionHandler(BindException.class)
    public ModelAndView BindExceptionHandler(HttpServletRequest request,
                                             HttpServletResponse response,
                                             BindException e) throws ServletException, IOException {
        ModelAndView mv = new ModelAndView();
        Map<String, String> map = new HashMap<>();
        e.getFieldErrors().forEach(fieldError -> {
            map.put(fieldError.getField(), fieldError.getDefaultMessage());
            System.out.println("+++++++++++++++" + fieldError.getField());
        });
        mv.addObject("error", map);
        String uri = request.getRequestURI();
        mv.setViewName(uri.substring(uri.lastIndexOf("/")+1));
        return mv;
    }
}
