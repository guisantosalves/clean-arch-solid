package com.bugpet.project.enums;

import lombok.Getter;

@Getter
public enum DamageEnum {

  WATER_DAMAGE(1),
  FIRE_DAMAGE(2),
  PHYSICAL_DAMAGE(3);

  private final int value;

  DamageEnum(int value) {
    this.value = value;
  }

  public static DamageEnum of(int value) {
    for (DamageEnum damage : values()) {
      if (damage.value == value) {
        return damage;
      }
    }
    throw new IllegalArgumentException("Invalid DamageEnum value: " + value);
  }
}
