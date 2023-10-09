package com.mjc.school.repository.implementation;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.repository.utils.DataSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class NewsRepositoryImpl implements BaseRepository<NewsModel, Long> {
    private final DataSource dataSource;

    public NewsRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<NewsModel> readAll() {
        List<NewsModel> newsModelList = dataSource.getNewsModelList();
        if (newsModelList.isEmpty()) {
            return null;
        }
        return newsModelList;
    }

    @Override
    public Optional<NewsModel> readById(Long id) {
        List<NewsModel> newsModelList = readAll();
        for (NewsModel e : newsModelList) {
            if (e.getId() == id) {
                return Optional.of(e);
            }
        }
        return null;
    }

    @Override
    public NewsModel create(NewsModel entity) {
        if (existById(entity.getId())) {
            NewsModel newsModel = dataSource.createNewsModel(entity);
            return newsModel;
        }
        return null;
    }

    @Override
    public NewsModel update(NewsModel entity) {
        Optional<NewsModel> newsModel = readById(entity.getId());
        newsModel.get().setId(entity.getId());
        newsModel.get().setTitle(entity.getTitle());
        newsModel.get().setContent(entity.getContent());
        newsModel.get().setStartDate(entity.getStartDate());
        newsModel.get().setLastUpdateDate(entity.getLastUpdateDate());
        newsModel.get().setAuthorId(entity.getAuthorId());
        dataSource.deleteNewsById(entity.getId());
        dataSource.createNewsModel(newsModel.get());
        return newsModel.get();
    }

    @Override
    public boolean deleteById(Long id) {
        return dataSource.deleteNewsById(id);
    }

    @Override
    public boolean existById(Long id) {
        List<NewsModel> newsModelList = readAll();
        for (NewsModel e : newsModelList) {
            if (e.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
