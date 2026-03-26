package com.bugpet.project.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class PetDto {
  private String id;
  private String name;
  private Short age;
  private BigDecimal life;
}
