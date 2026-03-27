package com.bugpet.project.service.bugpet;

import com.bugpet.project.dto.DamageStructureDto;
import com.bugpet.project.dto.PetDto;
import com.bugpet.project.entity.Pet;
import com.bugpet.project.mapper.PetMapper;
import com.bugpet.project.repository.PetRepository;
import com.bugpet.project.strategy.damage.CombatSystem;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class BugPetServiceImpl implements BugPetService {

  private final PetRepository petRepo;
  private final PetMapper petMapper;

  // O Spring coleta todos os beans que implementam DamageStrategy e injeta como lista no construtor automaticamente.
  // se eu criar criar um PoisonDamage implements DamageStrategy com @Component, ele entra na lista automaticamente
  private final CombatSystem combatSystem;

  @Override
  public PetDto createBugPet(PetDto petDto) {
    Pet pet = petMapper.toEntity(petDto);
    pet = petRepo.save(pet);
    return petMapper.toDto(pet);
  }

  @Override
  public PetDto damageBugPet(DamageStructureDto damageStructure) {
    Pet pet =
        petRepo.findById(damageStructure.getPetId())
            .orElseThrow(() -> new RuntimeException("Não encontrou o pet"));

    if (pet.getLife().compareTo(BigDecimal.ZERO) < 0) {
      throw new RuntimeException("seu pet ta morto");
    }

    // aplica o dano com base no tipo
    combatSystem.applyDamage(damageStructure.getType(), pet, damageStructure.getValue());

    pet = petRepo.save(pet);

    // passo o pet que recebeu o dano
    return petMapper.toDto(pet);
  }
}
