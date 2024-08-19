package com.siferga.collaborator.service;

import com.siferga.collaborator.model.Collaborator;
import com.siferga.collaborator.repository.CollaboratorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CollaboratorService {

    private final CollaboratorRepository collaboratorRepository;

    public CollaboratorService(CollaboratorRepository collaboratorRepository) {
        this.collaboratorRepository = collaboratorRepository;
    }

    public Collaborator save(Collaborator collaborator) {
        return collaboratorRepository.save(collaborator);
    }

    public List<Collaborator> findAll() {
        return collaboratorRepository.findAll();
    }

    public Optional<Collaborator> findById(Long id) {
        return collaboratorRepository.findById(id);
    }

    public String updateCollaborator(Long id, Collaborator collaborator) {
        collaboratorRepository.findById(id).get().getEmail().equals(collaborator.getEmail());
        collaboratorRepository.save(collaborator);
        return "Collaborator updated";

    }
    public void deleteCollaborator(Long id) {
        collaboratorRepository.deleteById(id);
    }

}
