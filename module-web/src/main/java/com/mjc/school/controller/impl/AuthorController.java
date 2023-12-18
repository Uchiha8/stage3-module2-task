package com.mjc.school.controller.impl;

import com.mjc.school.controller.BaseController;
import com.mjc.school.service.dto.AuthorDTORequest;
import com.mjc.school.service.dto.AuthorDTOResponse;
import com.mjc.school.service.implementation.AuthorService;
import com.mjc.school.service.validation.AuthorNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthorController implements BaseController<AuthorDTORequest, AuthorDTOResponse, Long> {

    private final AuthorService authorService;

    private static Logger logger = LogManager.getLogger(AuthorController.class);

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Override
    public List<AuthorDTOResponse> readAll() {
        List<AuthorDTOResponse> authorDTOResponses = null;
        try {
            authorDTOResponses = authorService.readAll();
        } catch (AuthorNotFoundException e) {
            logger.error(e.getMessage());
        }
        return authorDTOResponses;
    }

    @Override
    public AuthorDTOResponse readById(Long id) {
        AuthorDTOResponse authorDTOResponse = null;
        try {
            authorDTOResponse = authorService.readById(id);
        } catch (AuthorNotFoundException e) {
            logger.error(e.getMessage());
        }
        return authorDTOResponse;
    }

    @Override
    public AuthorDTOResponse create(AuthorDTORequest createRequest) {
        AuthorDTOResponse authorDTOResponse = null;
        try {
            authorDTOResponse = authorService.create(createRequest);
        } catch (RuntimeException e) {
            logger.error(e.getMessage());
        }
        return authorDTOResponse;
    }

    @Override
    public AuthorDTOResponse update(AuthorDTORequest updateRequest) {
        AuthorDTOResponse authorDTOResponse = null;
        try {
            authorDTOResponse = authorService.update(updateRequest);
        } catch (RuntimeException e) {
            logger.error(e.getMessage());
        }
        return authorDTOResponse;
    }

    @Override
    public boolean deleteById(Long id) {
        if (authorService.deleteById(id)) {
            return true;
        }
        return false;
    }
}
