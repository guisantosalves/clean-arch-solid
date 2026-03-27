package com.bugpet.project.mapper;

import com.bugpet.project.dto.AncestorDto;
import com.bugpet.project.entity.Ancestor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AncestorMapper {

  AncestorDto toDto(Ancestor ancestor);

  Ancestor toEntity(AncestorDto ancestorDto);
}
