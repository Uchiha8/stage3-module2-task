package com.mjc.school.service.implementation;

import com.mjc.school.repository.implementation.AuthorRepositoryImpl;
import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.AuthorDTORequest;
import com.mjc.school.service.dto.AuthorDTOResponse;
import com.mjc.school.service.mapper.AuthorMapper;
import com.mjc.school.service.validation.AuthorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements BaseService<AuthorDTORequest, AuthorDTOResponse, Long> {
    private final AuthorRepositoryImpl authorRepository;

    private final AuthorMapper authorMapper;

    @Autowired
    public AuthorService(AuthorRepositoryImpl authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    @Override
    public List<AuthorDTOResponse> readAll() throws AuthorNotFoundException {
        List<AuthorDTOResponse> responseList = null;
        List<AuthorModel> models = authorRepository.readAll();
        if (models != null) {
            for (AuthorModel author : models) {
                responseList.add(authorMapper.modelToDto(author));
            }
            return responseList;
        }
        throw new AuthorNotFoundException("Author List is empty");
    }

    @Override
    public AuthorDTOResponse readById(Long id) throws AuthorNotFoundException {
        Optional<AuthorModel> authorModel = authorRepository.readById(id);
        if (authorModel.isPresent()) {
            return authorMapper.modelToDto(authorModel.get());
        }
        throw new AuthorNotFoundException("Author is not found with ID: " + id);
    }

    @Override
    public AuthorDTOResponse create(AuthorDTORequest createRequest) {
        AuthorModel authorModel = authorMapper.dtoToModel(createRequest);
        if (validParamAuthor(authorModel)) {
            return authorMapper.modelToDto(authorRepository.create(authorModel));
        }
        throw new RuntimeException("Please provide valid object");
    }

    @Override
    public AuthorDTOResponse update(AuthorDTORequest updateRequest) {
        AuthorModel authorModel = authorMapper.dtoToModel(updateRequest);
        if (validParamAuthor(authorModel)) {
            return authorMapper.modelToDto(authorRepository.update(authorModel));
        }
        throw new RuntimeException("Please provide valid object");
    }

    @Override
    public boolean deleteById(Long id) throws AuthorNotFoundException {
        if (authorRepository.deleteById(id)) {
            return true;
        }
        throw new AuthorNotFoundException("Author could not removed with ID: " + id);
    }

    public boolean validParamAuthor(AuthorModel authorModel) {
        int nameLength = authorModel.getName().length();
        if (nameLength <= 3 || nameLength >= 15) {
            throw new RuntimeException("The length of name attribute should not be less than 3 or greater than 15");
        }
        return true;
    }
}
