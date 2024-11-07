package org.siferga.knowledge.repository;


import org.siferga.knowledge.entity.Knowledge;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KnowledgeRepository extends MongoRepository<Knowledge, String> {

}