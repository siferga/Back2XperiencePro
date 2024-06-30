package com.siferga.webapp.service;

import com.siferga.webapp.model.Collaborator;
import com.siferga.webapp.service.client.CollaboratorFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CollaboratorServiceImpl implements ICollaboratorService{
    private final CollaboratorFeignClient collaboratorFeignClient;

    @Override
    public Collaborator registerCollaborator (Collaborator collaborator) {
        collaborator.setFirstname(collaborator.getFirstname());
        collaborator.setLastname(collaborator.getLastname());
        collaborator.setBirthday(collaborator.getBirthday());
        collaborator.setEmail(collaborator.getEmail());
        collaborator.setPhone(collaborator.getPhone());
        collaborator.setGender(collaborator.getGender());
        collaborator.setAddress(collaborator.getAddress());
        return collaboratorFeignClient.createCollaborator(collaborator);
    }


    @Override
    public List<Collaborator> findAllCollaborators() {
        return collaboratorFeignClient.getAllCollaborators().getBody();
    }


//    @Override
//    public Patient findPatientByUsername(String firstname) {
//        return patientFeignClient.;
//    }

    public Collaborator findById(Long id) {
        return collaboratorFeignClient.findCollaboratorById(id).getBody();
    }


    @Override
    public Collaborator updateCollaborator(Long id, Collaborator updatedCollaborator) {
        ResponseEntity<Collaborator> responseEntity = collaboratorFeignClient.findCollaboratorById(id);
        Collaborator collaborator = responseEntity.getBody();
        collaborator.setFirstname(updatedCollaborator.getFirstname());
        collaborator.setLastname(updatedCollaborator.getLastname());
        collaborator.setBirthday(updatedCollaborator.getBirthday());
        collaborator.setEmail(updatedCollaborator.getEmail());
        collaborator.setPhone(updatedCollaborator.getPhone());
        collaborator.setGender(updatedCollaborator.getGender());
        collaborator.setAddress(updatedCollaborator.getAddress());

        // Save the updated patient back using the Feign client
        return collaboratorFeignClient.createCollaborator(collaborator);
    }

    public void deleteCollaborator(Long id) {
        collaboratorFeignClient.deleteCollaborator(id);
    }
}
