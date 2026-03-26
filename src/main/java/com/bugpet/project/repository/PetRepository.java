package com.bugpet.project.repository;

import com.bugpet.project.entity.Pet;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, UUID> {
}
