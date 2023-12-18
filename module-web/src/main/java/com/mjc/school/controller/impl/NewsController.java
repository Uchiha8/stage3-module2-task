package com.mjc.school.controller.impl;

import com.mjc.school.controller.BaseController;
import com.mjc.school.service.dto.NewsDTORequest;
import com.mjc.school.service.dto.NewsDTOResponse;
import com.mjc.school.service.implementation.NewsService;
import com.mjc.school.service.validation.NewsNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class NewsController implements BaseController<NewsDTORequest, NewsDTOResponse, Long> {

    private final NewsService newsService;
    private static Logger logger = LogManager.getLogger(NewsController.class);

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @Override
    public List<NewsDTOResponse> readAll() {
        List<NewsDTOResponse> newsDTOResponseList = null;
        try {
            newsDTOResponseList = newsService.readAll();
        } catch (NewsNotFoundException e) {
            logger.error(e.getMessage());
        }
        return newsDTOResponseList;
    }

    @Override
    public NewsDTOResponse readById(Long id) {
        NewsDTOResponse response = null;
        try {
            response = newsService.readById(id);
        } catch (NewsNotFoundException e) {
            logger.error(e.getMessage());
        }
        return response;
    }

    @Override
    public NewsDTOResponse create(NewsDTORequest createRequest) {
        NewsDTOResponse response = null;
        try {
            response = newsService.create(createRequest);
        } catch (RuntimeException e) {
            logger.error(e.getMessage());
        }
        return response;
    }

    @Override
    public NewsDTOResponse update(NewsDTORequest updateRequest) {
        NewsDTOResponse response = null;
        try {
            response = newsService.update(updateRequest);
        } catch (RuntimeException e) {
            logger.error(e.getMessage());
        }
        return response;
    }

    @Override
    public boolean deleteById(Long id) {
        if (newsService.deleteById(id)) {
            return true;
        }
        return false;
    }
}
