package com.mjc.school.service.mapper;

import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.service.dto.AuthorDTORequest;
import com.mjc.school.service.dto.AuthorDTOResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {
    AuthorModel dtoToModel(AuthorDTORequest authorDTORequest);

    AuthorDTOResponse modelToDto(AuthorModel authorModel);
}
