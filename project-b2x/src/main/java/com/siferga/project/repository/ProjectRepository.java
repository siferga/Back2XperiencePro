package com.siferga.project.repository;

import com.siferga.project.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
//    @Query("SELECT c FROM Collaborator c JOIN c.projects p WHERE p.id = :projectId")
//    List<Collaborator> findCollaboratorsByProjectId(@Param("projectId") Long projectId);
}

