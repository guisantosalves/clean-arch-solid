package com.bugpet.project.factory;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;

@Component
public class FireAncestorAction implements AncestorAction {
  @Override
  public void mainAttack(BigDecimal damage) {
    System.out.println("FLAMES ATTACKING!!"+damage+" damage.");
  }

  @Override
  public void growl() {
    System.out.println("DRAKE Growl");
  }
}
