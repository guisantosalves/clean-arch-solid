package com.bugpet.project.observer;

import com.bugpet.project.enums.PetAncestorTypeEnum;

public class DevelopedVillage implements VillageObserver {
  @Override
  public void onAncestorAttack(PetAncestorTypeEnum ancestorTypeEnum) {
    switch (ancestorTypeEnum) {
      case FIRE, PHYSICAL, WATER -> {
        System.out.println("Todo mundo VIVE");
      }
    }
  }
}
