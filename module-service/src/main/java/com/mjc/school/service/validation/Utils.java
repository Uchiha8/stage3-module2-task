package com.mjc.school.service.validation;

import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.repository.model.NewsModel;
import org.springframework.stereotype.Component;

public class Utils {
    public boolean validParamNews(NewsModel newsModel) {
        int titleLength = newsModel.getTitle().length();
        if (titleLength <= 5 || titleLength >= 30) {
            throw new RuntimeException("The title's length should not be less than 5 or greater than 30!!!");
        }
        int contentLength = newsModel.getContent().length();
        if (contentLength <= 5 || contentLength >= 255) {
            throw new RuntimeException("The content's length should not be less than 5 or greater than 255");
        }
        return true;
    }

    public boolean validParamAuthor(AuthorModel authorModel) {
        int nameLength = authorModel.getName().length();
        if (nameLength <= 3 || nameLength >= 15) {
            throw new RuntimeException("The length of name attribute should not be less than 3 or greater than 15");
        }
        return true;
    }
}
