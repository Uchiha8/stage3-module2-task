package com.mjc.school.service.implementation;

import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.NewsDTORequest;
import com.mjc.school.service.dto.NewsDTOResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService implements BaseService<NewsDTORequest, NewsDTOResponse, Long> {

    @Override
    public List<NewsDTOResponse> readAll() {
        return null;
    }

    @Override
    public NewsDTOResponse readById(Long id) {
        return null;
    }

    @Override
    public NewsDTOResponse create(NewsDTORequest createRequest) {
        return null;
    }

    @Override
    public NewsDTOResponse update(NewsDTORequest updateRequest) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
