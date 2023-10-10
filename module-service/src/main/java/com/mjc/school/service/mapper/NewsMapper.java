package com.mjc.school.service.mapper;

import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.service.dto.NewsDTORequest;
import com.mjc.school.service.dto.NewsDTOResponse;
import org.mapstruct.Mapper;

@Mapper
public interface NewsMapper {
    NewsModel dtoToModel(NewsDTORequest newsDTORequest);

    NewsDTOResponse modelToDto(NewsModel newsModel);
}
