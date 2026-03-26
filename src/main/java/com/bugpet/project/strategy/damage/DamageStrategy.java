package com.bugpet.project.strategy.damage;

import com.bugpet.project.entity.Pet;
import com.bugpet.project.enums.DamageEnum;
import java.math.BigDecimal;

public interface DamageStrategy {
  void handleDamage(Pet pet, BigDecimal damageValue);
  DamageEnum getType();
}
