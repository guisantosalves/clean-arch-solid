package com.bugpet.project.dto;

import com.bugpet.project.enums.DamageEnum;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.Data;

@Data
public class DamageStructureDto {
  private BigDecimal value;
  private DamageEnum type;
  private UUID petId;
}
