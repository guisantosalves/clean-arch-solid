package com.bugpet.project.service.bugpet;

import com.bugpet.project.dto.DamageStructureDto;
import com.bugpet.project.dto.PetDto;

public interface BugPetService {
  PetDto createBugPet(PetDto petDto);

  PetDto damageBugPet(DamageStructureDto damageStructure);
}
