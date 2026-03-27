package com.bugpet.project.dto;

import com.bugpet.project.enums.PetAncestorTypeEnum;
import java.util.UUID;
import lombok.Data;

@Data
public class AncestorDto {
  private UUID id;
  private String name;
  private String from;
  private String age;
  private PetAncestorTypeEnum type;
}
