package com.bugpet.project.observer;

import com.bugpet.project.enums.PetAncestorTypeEnum;

public interface VillageObserver {
  void onAncestorAttack(PetAncestorTypeEnum ancestorTypeEnum);
}
