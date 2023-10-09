package com.mjc.school.repository.utils;

import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.repository.model.NewsModel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataSource {
    private static DataSource dataSource;

    private static List<NewsModel> newsModelList = new ArrayList<>();
    private static List<AuthorModel> authorModelList = new ArrayList<>();

    private static final String AUTHOR_FILE_PATH = "module-repository/src/main/resources/authors";
    private static final String NEWS_FILE_PATH = "module-repository/src/main/resources/news";
    private static final String CONTENT_FILE_PATH = "module-repository/src/main/resources/content";

    private DataSource() {
        init();
    }

    public static DataSource getInstance() {
        if (dataSource == null) {
            dataSource = new DataSource();
        }
        return dataSource;
    }

    private void init() {
        parseAuthorModel();
        parseNewsModel();
    }

    private void parseNewsModel() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(NEWS_FILE_PATH));
            String title;
            long id = 1;
            Random random = new Random();
            while ((title = bufferedReader.readLine()) != null) {
                try {
                    BufferedReader bufferedReader1 = new BufferedReader(new FileReader(CONTENT_FILE_PATH));
                    String content;
                    while ((content = bufferedReader1.readLine()) != null) {
                        LocalDateTime startDate = LocalDateTime.now();
                        LocalDateTime lastUpdateDate = LocalDateTime.now();
                        long authorId = random.nextLong(getAuthorModelList().size()) + 1;
                        newsModelList.add(new NewsModel(id, title, content, startDate, lastUpdateDate, authorId));
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void parseAuthorModel() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(AUTHOR_FILE_PATH));
            String author;
            long id = 1;
            while ((author = bufferedReader.readLine()) != null) {
                authorModelList.add(new AuthorModel(id, author));
                id++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<NewsModel> getNewsModelList() {
        return newsModelList;
    }

    public List<AuthorModel> getAuthorModelList() {
        return authorModelList;
    }

    public AuthorModel createAuthor(AuthorModel authorModel) {
        authorModelList.add(authorModel);
        return authorModel;
    }

    public NewsModel createNewsModel(NewsModel newsModel) {
        newsModelList.add(newsModel);
        return newsModel;
    }

    public Boolean deleteAuthorById(Long id) {
        for (AuthorModel e : authorModelList) {
            if (e.getId().equals(id)) {
                return authorModelList.remove(e);
            }
        }
        return false;
    }

    public Boolean deleteNewsById(Long id) {
        for (NewsModel e : newsModelList) {
            if (e.getId() == id) {
                return newsModelList.remove(e);
            }
        }
        return false;
    }

}
