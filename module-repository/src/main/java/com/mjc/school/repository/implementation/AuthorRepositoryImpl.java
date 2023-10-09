package com.mjc.school.repository.implementation;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.repository.utils.DataSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepositoryImpl implements BaseRepository<AuthorModel, Long> {

    private final DataSource dataSource;

    public AuthorRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public List<AuthorModel> readAll() {
        return dataSource.getAuthorModelList();
    }

    @Override
    public Optional<AuthorModel> readById(Long id) {
        List<AuthorModel> authorModelList = readAll();
        for (AuthorModel author : authorModelList) {
            if (author.getId().equals(id)) {
                return Optional.of(author);
            }
        }
        return null;
    }

    @Override
    public AuthorModel create(AuthorModel entity) {
        if (!existById(entity.getId())) {
            return dataSource.createAuthor(entity);
        }
        return null;
    }

    @Override
    public AuthorModel update(AuthorModel entity) {
        Optional<AuthorModel> authorModel = readById(entity.getId());
        authorModel.get().setName(entity.getName());
        deleteById(authorModel.get().getId());
        dataSource.createAuthor(entity);
        return entity;
    }

    @Override
    public boolean deleteById(Long id) {
        if (existById(id)) {
            return dataSource.deleteAuthorById(id);
        }
        return false;
    }

    @Override
    public boolean existById(Long id) {
        Optional<AuthorModel> authorModel = readById(id);
        if (authorModel.isEmpty()) {
            return false;
        }
        return true;
    }
}
