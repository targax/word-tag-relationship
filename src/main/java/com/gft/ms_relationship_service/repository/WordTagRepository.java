package com.gft.ms_relationship_service.repository;

import com.gft.ms_relationship_service.entity.WordTagRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordTagRepository extends JpaRepository<WordTagRelationship, Long> {
}
