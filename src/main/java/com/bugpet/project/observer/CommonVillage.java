package com.bugpet.project.observer;

import com.bugpet.project.enums.PetAncestorTypeEnum;

public class CommonVillage implements VillageObserver {
  @Override
  public void onAncestorAttack(PetAncestorTypeEnum ancestorTypeEnum) {
    switch (ancestorTypeEnum) {
      case FIRE, PHYSICAL -> {
        System.out.println("Todo mundo morre");
      }
      case WATER -> {
        System.out.println("Todo mundo nada sobre a agua");
      }
    }
  }
}
