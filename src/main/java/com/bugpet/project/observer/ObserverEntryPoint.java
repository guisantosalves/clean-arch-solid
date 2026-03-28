package com.bugpet.project.observer;

public interface ObserverEntryPoint {
  void subscribe(VillageObserver villageObserver);

  void unsubscribe(VillageObserver villageObserver);
}
