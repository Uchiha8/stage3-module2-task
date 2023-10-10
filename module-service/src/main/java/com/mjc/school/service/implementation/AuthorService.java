package com.mjc.school.service.implementation;

import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.AuthorDTORequest;
import com.mjc.school.service.dto.AuthorDTOResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorService implements BaseService<AuthorDTORequest, AuthorDTOResponse, Long> {
    @Override
    public List<AuthorDTOResponse> readAll() {
        return null;
    }

    @Override
    public AuthorDTOResponse readById(Long id) {
        return null;
    }

    @Override
    public AuthorDTOResponse create(AuthorDTORequest createRequest) {
        return null;
    }

    @Override
    public AuthorDTOResponse update(AuthorDTORequest updateRequest) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
