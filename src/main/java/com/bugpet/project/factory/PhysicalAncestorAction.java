package com.bugpet.project.factory;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;

@Component
public class PhysicalAncestorAction implements AncestorAction {
  @Override
  public void mainAttack(BigDecimal damage) {
    System.out.println("FIST STRIKE ATTACKING!!"+damage+" damage.");
  }

  @Override
  public void growl() {
    System.out.println("MONK Growl");
  }
}
