package com.bugpet.project.controller;

import com.bugpet.project.dto.AncestorDto;
import com.bugpet.project.enums.PetAncestorTypeEnum;
import com.bugpet.project.service.ancestor.AncestorService;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ancestor")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AncestorController {

  private final AncestorService ancestorService;

  @PostMapping
  public ResponseEntity<AncestorDto> createAncestor(@RequestBody AncestorDto ancestorDto) {
    ancestorDto.setId(null);
    AncestorDto created = ancestorService.createAncestor(ancestorDto);
    return new ResponseEntity<>(created, HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<AncestorDto> findAncestor(@PathVariable UUID id) {
    AncestorDto ancestor = ancestorService.findAncestor(id);
    return new ResponseEntity<>(ancestor, HttpStatus.OK);
  }

  @PostMapping("/fight/{id}")
  public ResponseEntity<Void> fightAncestor(@PathVariable UUID id, @RequestParam BigDecimal damage) {
    ancestorService.fightAncestor(id, damage);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
