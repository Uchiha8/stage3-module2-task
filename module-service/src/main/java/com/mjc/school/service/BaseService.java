package com.mjc.school.service;

import com.mjc.school.service.validation.AuthorNotFoundException;
import com.mjc.school.service.validation.NewsNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BaseService<T, R, K> {
    List<R> readAll() throws Exception;

    R readById(K id) throws Exception;

    R create(T createRequest);

    R update(T updateRequest);

    boolean deleteById(K id) throws Exception;
}
