package com.bugpet.project.strategy.damage;

import com.bugpet.project.entity.Pet;
import com.bugpet.project.enums.DamageEnum;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

// context -> a strategy cuida do "qual dano", o CombatSystem cuida do "como/quando aplicar".
@Component
public class CombatSystem {
  private final Map<DamageEnum, DamageStrategy> damageStrategy;

  public CombatSystem(List<DamageStrategy> strategyList) {
    /*
    - .stream() — transforma a lista num fluxo pra poder usar operações funcionais
    - .collect(Collectors.toMap(...)) — coleta o resultado num Map
    - DamageStrategy::getType — a chave do map. Pra cada strategy, chama o getType() dela. Então FireDamage vira chave
      FIRE_DAMAGE
    - Function.identity() — o valor do map. Significa "o próprio objeto". Ou seja, o valor é a strategy em si
     */
    this.damageStrategy = strategyList.stream().collect(Collectors.toMap(DamageStrategy::getType,
        Function.identity()));
  }

  public void applyDamage(DamageEnum damageEnum, Pet pet, BigDecimal damageValue) {
    damageStrategy.get(damageEnum).handleDamage(pet, damageValue);
  }
}
