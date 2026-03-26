package com.bugpet.project.mapper;

import com.bugpet.project.dto.PetDto;
import com.bugpet.project.entity.Pet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PetMapper {

  PetDto toDto(Pet pet);

  Pet toEntity(PetDto petDto);
}
