package com.bugpet.project.service.ancestor;

import com.bugpet.project.dto.AncestorDto;
import com.bugpet.project.entity.Ancestor;
import com.bugpet.project.enums.PetAncestorTypeEnum;
import com.bugpet.project.factory.AncestorActionFactory;
import com.bugpet.project.mapper.AncestorMapper;
import com.bugpet.project.repository.AncestorRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AncestorServiceImpl implements AncestorService {

  private final AncestorRepository ancestorRepository;
  private final AncestorMapper ancestorMapper;
  private final Map<PetAncestorTypeEnum, AncestorActionFactory> factories;


  public AncestorServiceImpl(AncestorRepository ancestorRepository, AncestorMapper ancestorMapper,
      List<AncestorActionFactory> factoryList) {
    this.ancestorRepository = ancestorRepository;
    this.ancestorMapper = ancestorMapper;
    this.factories = factoryList.stream()
        .collect(Collectors.toMap(AncestorActionFactory::getType, Function.identity()));
  }

  @Override
  public AncestorDto createAncestor(AncestorDto ancestorDto) {
    Ancestor ancestor = ancestorMapper.toEntity(ancestorDto);
    ancestor = ancestorRepository.save(ancestor);
    return ancestorMapper.toDto(ancestor);
  }

  @Override
  public AncestorDto findAncestor(UUID id) {
    Ancestor ancestor = ancestorRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Ancestor não encontrado"));
    return ancestorMapper.toDto(ancestor);
  }

  @Override
  public void fightAncestor(UUID id, BigDecimal damage) {
    Ancestor ancestor = ancestorRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Ancestor não encontrado"));

    factories.get(ancestor.getType()).attackFromAncestor(damage);
  }
}
