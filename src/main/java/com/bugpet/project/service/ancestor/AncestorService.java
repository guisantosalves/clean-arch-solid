package com.bugpet.project.service.ancestor;

import com.bugpet.project.dto.AncestorDto;
import com.bugpet.project.enums.PetAncestorTypeEnum;
import java.math.BigDecimal;
import java.util.UUID;

public interface AncestorService {
  AncestorDto createAncestor(AncestorDto ancestor);

  AncestorDto findAncestor(UUID id);

  void fightAncestor(UUID id, BigDecimal damage);
}
