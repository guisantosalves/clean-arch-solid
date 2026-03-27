package com.bugpet.project.factory;

import com.bugpet.project.enums.PetAncestorTypeEnum;
import java.math.BigDecimal;

public abstract class AncestorActionFactory {
 /*
    public AncestorAction create(PetAncestorTypeEnum type) {
      return switch (type) {
        case FIRE -> new FireAncestorAction();
        case WATER -> new WaterAncestorAction();
        case PHYSICAL -> new PhysicalAncestorAction();
      };
    }

    public void attackFromAncestor(PetAncestorTypeEnum type, BigDecimal damage) {
      create(type).mainAttack(damage);
    }
  */

  public abstract AncestorAction createAncestorAction();

  public abstract PetAncestorTypeEnum getType();

  public void attackFromAncestor(BigDecimal damage) {
    AncestorAction ancestorAction = createAncestorAction();
    ancestorAction.mainAttack(damage);
  }
}

