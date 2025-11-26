package com.gft.ms_relationship_service.service;

import com.gft.ms_relationship_service.entity.WordTagRelationship;
import com.gft.ms_relationship_service.repository.WordTagRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WordTagService {

    private final WordTagRepository wordTagRepository;

    public WordTagService(WordTagRepository wordTagRepository) {
        this.wordTagRepository = wordTagRepository;
    }

    public WordTagRelationship create(WordTagRelationship wordTagRelationship){
        return wordTagRepository.save(wordTagRelationship);
    }

    public void delete(Long id){
        WordTagRelationship response=wordTagRepository.findById(id).orElseThrow(() -> new RuntimeException("id não encontrado"));
        wordTagRepository.deleteById(id);
    }


}
