package com.bugpet.project.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class DiedPetDto {
  private String id;
  private String petId;
  private String petName;
  private String lastDamageType;
  private BigDecimal lastDamageValue;
  private LocalDateTime diedAt;
}
