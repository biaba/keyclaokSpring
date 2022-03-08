package com.keycloak.repositories;

import com.keycloak.entities.ComputerPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerPartRepository extends JpaRepository<ComputerPart, Long> {
}
