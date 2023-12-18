package com.mjc.school.controller;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BaseController<T, R, K> {

    List<R> readAll();

    R readById(K id);

    R create(T createRequest);

    R update(T updateRequest);

    boolean deleteById(K id);
}
