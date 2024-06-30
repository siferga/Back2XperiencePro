package com.siferga.webapp.service;

import com.siferga.webapp.model.Collaborator;

import java.util.List;

public interface ICollaboratorService {
    public Collaborator registerCollaborator(Collaborator collaborator);
    public List<Collaborator> findAllCollaborators();
    // public Patient getPatientById(Long id);
    //Patient findPatientByUsername(String firstname);
    public Collaborator updateCollaborator(Long id, Collaborator updatedCollaborator);
    //Patient findCollaboratorByUsername(String firstname);
    //public Collaborator addCollaborator(Collaborator collaborator);



    //    @Override
    //    public Collaborator updateCollaborator(Collaborator collaborator) {
    //        return null;
    //    }
}
