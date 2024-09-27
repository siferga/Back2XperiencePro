package com.siferga.webapp.service;

import com.siferga.webapp.model.Project;

import java.util.List;

public interface IProjectService {
    // Méthode pour enregistrer un projet
    Project registerProject(Project project);

    // Méthode pour récupérer tous les projets
    List<Project> findAllProjects();

    // Méthode pour récupérer un projet par son ID
    Project findById(Long id);

    // Méthode pour mettre à jour un projet
    Project updateProject(Long id, Project updatedProject);

    // Méthode pour supprimer un projet
    void deleteProject(Long id);

}
