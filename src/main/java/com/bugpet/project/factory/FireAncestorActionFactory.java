package com.bugpet.project.factory;

import com.bugpet.project.enums.PetAncestorTypeEnum;
import org.springframework.stereotype.Component;

@Component
public class FireAncestorActionFactory extends AncestorActionFactory {
  @Override
  public AncestorAction createAncestorAction() {
    return new FireAncestorAction();
  }

  @Override
  public PetAncestorTypeEnum getType() {
    return PetAncestorTypeEnum.FIRE;
  }
}
