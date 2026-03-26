package com.bugpet.project.service;

import com.bugpet.project.dto.DamageStructureDto;
import com.bugpet.project.dto.PetDto;
import com.bugpet.project.entity.Pet;

public interface BugPetService {
  PetDto createBugPet(PetDto petDto);

  PetDto damageBugPet(DamageStructureDto damageStructure);
}
