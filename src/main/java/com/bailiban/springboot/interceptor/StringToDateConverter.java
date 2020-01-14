package com.bailiban.springboot.interceptor;

import lombok.SneakyThrows;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class StringToDateConverter implements Converter<String, Date> {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @SneakyThrows
    @Override
    public Date convert(String source) {
        return format.parse(source);
    }
}
