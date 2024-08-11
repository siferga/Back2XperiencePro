package com.siferga.collaborator.repository;

import com.siferga.webapp.model.Collaborator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollaboratorRepository extends JpaRepository<Collaborator, Long > {
    Collaborator findByEmail(String email);
}
