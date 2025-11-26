package com.gft.ms_relationship_service.controller;

import com.gft.ms_relationship_service.entity.WordTagRelationship;
import com.gft.ms_relationship_service.service.WordTagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WordTagController {

    private final WordTagService wordTagService;

    public WordTagController(WordTagService wordTagService) {
        this.wordTagService = wordTagService;
    }

    @PostMapping
    public ResponseEntity<WordTagRelationship> create(@RequestBody WordTagRelationship request) {

        return ResponseEntity.ok(wordTagService.create(request));
    }
}
