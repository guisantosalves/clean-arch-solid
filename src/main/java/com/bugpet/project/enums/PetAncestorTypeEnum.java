package com.bugpet.project.enums;

import lombok.Getter;

@Getter
public enum PetAncestorTypeEnum {
  WATER(1),
  FIRE(2),
  PHYSICAL(3);

  private final int value;

  PetAncestorTypeEnum(int value) {
    this.value = value;
  }

  public static PetAncestorTypeEnum of(int value) {
    for (PetAncestorTypeEnum petAncestorTypeEnum : values()) {
      if (petAncestorTypeEnum.value == value) {
        return petAncestorTypeEnum;
      }
    }
    throw new IllegalArgumentException("Invalid DamageEnum value: " + value);
  }
}
