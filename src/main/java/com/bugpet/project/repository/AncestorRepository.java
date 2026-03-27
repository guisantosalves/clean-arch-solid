package com.bugpet.project.repository;

import com.bugpet.project.entity.Ancestor;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AncestorRepository extends JpaRepository<Ancestor, UUID> {
}
