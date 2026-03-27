package com.bugpet.project.entity;

import com.bugpet.project.enums.PetAncestorTypeEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ancestor")
@Getter
@Setter
public class Ancestor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String name;
  @Column(name = "origin")
  private String from;
  private String age;
  private PetAncestorTypeEnum type;

  @OneToMany(mappedBy = "ancestor")
  private List<Pet> pets;
}
