package com.bugpet.project.factory;

import com.bugpet.project.enums.PetAncestorTypeEnum;
import org.springframework.stereotype.Component;

@Component
public class PhysicalAncestorActionFactory extends AncestorActionFactory {
  @Override
  public AncestorAction createAncestorAction() {
    return new PhysicalAncestorAction();
  }

  @Override
  public PetAncestorTypeEnum getType() {
    return PetAncestorTypeEnum.PHYSICAL;
  }
}
