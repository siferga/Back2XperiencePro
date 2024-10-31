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

//    public String updateCollaborator(Long id, Collaborator collaborator) {
//        collaboratorRepository.findById(id).get().getEmail().equals(collaborator.getEmail());
//        collaboratorRepository.save(collaborator);
//        return "Collaborator updated";
//
//    }
    public String updateCollaborator(Long id, Collaborator collaborator) {
        Optional<Collaborator> existingCollaborator = collaboratorRepository.findById(id);
        if (existingCollaborator.isPresent()) {
            // Update fields of the existing collaborator with the new collaborator data
            Collaborator updatedCollaborator = existingCollaborator.get();
            updatedCollaborator.setFirstname(collaborator.getFirstname());
            updatedCollaborator.setLastname(collaborator.getLastname());
            updatedCollaborator.setBirthday(collaborator.getBirthday());
            updatedCollaborator.setEmail(collaborator.getEmail());
            updatedCollaborator.setPhone(collaborator.getPhone());
            updatedCollaborator.setGender(collaborator.getGender());
            updatedCollaborator.setAddress(collaborator.getAddress());
            collaboratorRepository.save(updatedCollaborator);
            return "Collaborator updated";
        } else {
            return "Collaborator not found";
        }
    }

    public void deleteCollaborator(Long id) {
        collaboratorRepository.deleteById(id);
    }

}
