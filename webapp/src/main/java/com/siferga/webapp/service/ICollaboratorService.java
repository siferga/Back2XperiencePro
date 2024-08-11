package com.siferga.webapp.service;

import com.siferga.webapp.model.Collaborator;

import java.util.List;

public interface ICollaboratorService {
    Collaborator registerCollaborator(Collaborator collaborator);

    List<Collaborator> findAllCollaborators();

    Collaborator updateCollaborator(Long id, Collaborator updatedCollaborator);
}
