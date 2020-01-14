package com.bailiban.springboot.service.impl;

import com.bailiban.springboot.service.IndexService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class IndexServiceImpl implements IndexService {

    @Cacheable("add")
    @Override
    public int add(int x, int y) {
        System.out.println("add");
        return x + y;
    }
}
