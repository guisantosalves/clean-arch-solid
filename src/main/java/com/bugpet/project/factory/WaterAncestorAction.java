package com.bugpet.project.factory;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;

@Component
public class WaterAncestorAction implements AncestorAction {
  @Override
  public void mainAttack(BigDecimal damage) {
    System.out.println("TIDAL WAVE ATTACKING!!" + damage + " damage ");
  }

  @Override
  public void growl() {
    System.out.println("LEVIATHAN Growl");
  }
}
