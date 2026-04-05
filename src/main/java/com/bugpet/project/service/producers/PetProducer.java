package com.bugpet.project.service.producers;

import com.bugpet.project.dto.DiedPetDto;

public interface PetProducer {
  void publishDiedPet(DiedPetDto diedPetDto);
}
