package com.mjc.school.service.implementation;

import com.mjc.school.repository.implementation.NewsRepositoryImpl;
import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.NewsDTORequest;
import com.mjc.school.service.dto.NewsDTOResponse;
import com.mjc.school.service.mapper.NewsMapper;
import com.mjc.school.service.validation.NewsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsService implements BaseService<NewsDTORequest, NewsDTOResponse, Long> {

    private final NewsRepositoryImpl newsRepository;
    @Autowired
    private NewsMapper newsMapper;

    @Autowired
    public NewsService(NewsRepositoryImpl newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public List<NewsDTOResponse> readAll() throws NewsNotFoundException {
        List<NewsDTOResponse> result = null;
        List<NewsModel> newsDTOResponseList = newsRepository.readAll();
        if (newsDTOResponseList != null) {
            for (NewsModel newModel : newsDTOResponseList) {
                result.add(newsMapper.modelToDto(newModel));
            }
            return result;
        }
        throw new NewsNotFoundException("The NewsModel List is empty");
    }

    @Override
    public NewsDTOResponse readById(Long id) throws NewsNotFoundException {
        Optional<NewsModel> newsModel = newsRepository.readById(id);
        if (newsModel.isPresent()) {
            return newsMapper.modelToDto(newsModel.get());
        }
        throw new NewsNotFoundException("News model is not found with ID: " + id);
    }

    @Override
    public NewsDTOResponse create(NewsDTORequest createRequest) {
        NewsModel model = newsMapper.dtoToModel(createRequest);
        if (validParamNews(model)) {
            NewsModel result = newsRepository.create(model);
            return newsMapper.modelToDto(result);
        }
        throw new RuntimeException("Please provide valid params");
    }

    @Override
    public NewsDTOResponse update(NewsDTORequest updateRequest) {
        NewsModel model = newsMapper.dtoToModel(updateRequest);
        if (validParamNews(model)) {
            NewsModel result = newsRepository.update(model);
            return newsMapper.modelToDto(result);
        }
        throw new RuntimeException("Please provide valid params");
    }

    @Override
    public boolean deleteById(Long id) {
        if (newsRepository.deleteById(id)) {
            return true;
        }
        return false;
    }

    public boolean validParamNews(NewsModel newsModel) {
        int titleLength = newsModel.getTitle().length();
        if (titleLength <= 5 || titleLength >= 30) {
            return false;
        }
        int contentLength = newsModel.getContent().length();
        if (contentLength <= 5 || contentLength >= 255) {
            return false;
        }
        return true;
    }
}
