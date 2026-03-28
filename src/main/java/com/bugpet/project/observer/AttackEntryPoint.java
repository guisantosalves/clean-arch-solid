package com.bugpet.project.observer;

import com.bugpet.project.enums.PetAncestorTypeEnum;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/*
   dá pra guardar no banco. A ideia seria:

  1. Ter as vilas persistidas como entidades (com um campo tipo name, type, etc.)
  2. Quando o attackHappened for chamado, o AttackEntryPoint busca as vilas no banco
  3. Pra cada vila retornada, executa a lógica de notificação baseado no tipo dela

  Nesse cenário tu trocaria a lista in-memory por uma query no repository. Algo tipo:

  public void attackHappened(PetAncestorTypeEnum ancestorTypeEnum) {
      List<Village> villages = villageRepository.findAll();
      // pra cada village, resolve o observer correto e notifica
  }

  A diferença é que ao invés de subscribe/unsubscribe manual,
  o "cadastro" de observers vira um CRUD no banco. O pattern continua o mesmo —
  o subject notifica N interessados — só muda de onde vem essa lista.
 */
@Component
public class AttackEntryPoint implements ObserverEntryPoint {
  private final List<VillageObserver> villageObservers = new ArrayList<>();

  @Override
  public void subscribe(VillageObserver villageObserver) {
    villageObservers.add(villageObserver);
  }

  @Override
  public void unsubscribe(VillageObserver villageObserver) {
    villageObservers.remove(villageObserver);
  }

  public void attackHappened(PetAncestorTypeEnum ancestorTypeEnum) {
    /// some logic could happen here


    notifyObserver(ancestorTypeEnum);
  }

  private void notifyObserver(PetAncestorTypeEnum ancestorTypeEnum) {
    for (VillageObserver villageObserver : villageObservers) {
      villageObserver.onAncestorAttack(ancestorTypeEnum);
    }
  }
}
