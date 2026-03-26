package com.bugpet.project.strategy.damage;

import com.bugpet.project.entity.Pet;
import com.bugpet.project.enums.DamageEnum;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class FireDamage implements DamageStrategy {
  private static final BigDecimal FIRE_DAMAGE_INCREASE = BigDecimal.valueOf(20);
  @Override
  public void handleDamage(Pet pet, BigDecimal damageValue) {
    BigDecimal totalDamage = damageValue.add(FIRE_DAMAGE_INCREASE);
    pet.setLife(pet.getLife().subtract(totalDamage));
  }

  @Override
  public DamageEnum getType() {
    return DamageEnum.FIRE_DAMAGE;
  }
}
