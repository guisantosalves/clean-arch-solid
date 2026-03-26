package com.bugpet.project.singleton;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// public static AppLogger getInstance() {
//   if (instance == null) {
//     synchronized (AppLogger.class) {
//       if (instance == null) {
//         instance = new AppLogger();
//       }
//     }
//   }
//   return instance;
// }
//
// public void log(String message) {
//   String entry = LocalDateTime.now() + " - " + message;
//   logs.add(entry);
//   System.out.println(entry);
// }
//
// public List<String> getLogs() {
//   return Collections.unmodifiableList(logs);
// }


public class AppLogger {
  // Resumindo: sem volatile, uma thread pode receber uma instância "pela metade" — a referência existe mas o objeto ainda não foi construído por completo.
  private static volatile AppLogger instance;
  private final List<String> logs = new ArrayList<>();

  public static AppLogger getInstance() {
    // se o instance nao existe ele cria
    // apenas uma instancia para todas as threads
    if (instance == null) {
      synchronized (AppLogger.class) {
        if (instance == null) {
          instance = new AppLogger();
        }
      }
    }
    return instance;
  }

  public void log(String message) {
    String currMess = LocalDate.now() + " [INTERNAL LOG] - " + message;
    logs.add(currMess);
    System.out.println(currMess);
  }

  public List<String> getLogs() {
    // protege pra nao modificar
    return Collections.unmodifiableList(logs);
  }
}
