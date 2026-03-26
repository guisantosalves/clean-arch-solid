package com.bugpet.project.controller;

import com.bugpet.project.dto.DamageStructureDto;
import com.bugpet.project.dto.PetDto;
import com.bugpet.project.service.BugPetService;
import com.bugpet.project.singleton.AppLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/bug-pet")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class BugPetController {
  private final AppLogger appLogger = AppLogger.getInstance();
  private final BugPetService bugPetService;

  @GetMapping
  public ResponseEntity<String> helloFromBugPet() {
    appLogger.log("Testando Hello world");
    return new ResponseEntity<>("Hello From bugPet", HttpStatus.OK);
  }

  @PostMapping()
  public ResponseEntity<PetDto> createMyBug(@RequestBody PetDto petDto) {
    appLogger.log("Criando BugPet");
    petDto.setId(null);
    PetDto petCreated = bugPetService.createBugPet(petDto);
    return new ResponseEntity<>(petCreated, HttpStatus.OK);
  }

  @PostMapping("/damage")
  public ResponseEntity<PetDto> createMyBug(@RequestBody DamageStructureDto damageStructureDto) {
    appLogger.log("Criando BugPet");
    PetDto petDamaged = bugPetService.damageBugPet(damageStructureDto);
    return new ResponseEntity<>(petDamaged, HttpStatus.OK);
  }
}
