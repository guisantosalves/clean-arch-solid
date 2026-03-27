package com.bugpet.project.factory;

import com.bugpet.project.enums.PetAncestorTypeEnum;
import org.springframework.stereotype.Component;

@Component
public class WaterAncestorActionFactory extends AncestorActionFactory {
  @Override
  public AncestorAction createAncestorAction() {
    return new WaterAncestorAction();
  }

  @Override
  public PetAncestorTypeEnum getType() {
    return PetAncestorTypeEnum.WATER;
  }
}
