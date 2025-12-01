package com.gft.ms_relationship_service.controller;

import com.gft.ms_relationship_service.dto.CreateRelationshipRequest;
import com.gft.ms_relationship_service.dto.RelationshipResponse;
import com.gft.ms_relationship_service.entity.WordTagRelationship;
import com.gft.ms_relationship_service.service.WordTagService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/relationship")
public class WordTagController {

    private final WordTagService wordTagService;

    public WordTagController(WordTagService wordTagService) {
        this.wordTagService = wordTagService;
    }

    @Operation(summary = "Cria uma associação entre palavra e etiqueta")
    @ApiResponse(responseCode = "201", description = "Associação criada com sucesso")
    @PostMapping
    public ResponseEntity<RelationshipResponse> create(@Valid @RequestBody CreateRelationshipRequest request) {

        WordTagRelationship entity = wordTagService.create(request);

        return ResponseEntity.status(201).body(
                new RelationshipResponse(entity.getId(), entity.getWordId(), entity.getTagId())
        );
    }

    @Operation(summary = "Lista todas as palavras associadas a uma tag")
    @GetMapping("/palavras-por-tag/{tagId}")
    public ResponseEntity<List<Long>> getPalavrasPorTag(@PathVariable Long tagId) {

        return ResponseEntity.ok(wordTagService.getPalavrasPorTag(tagId));
    }

    @Operation(summary = "Lista todas as tags associadas a uma palavra")
    @GetMapping("/tags-por-palavra/{wordId}")
    public ResponseEntity<List<Long>> getTagsPorPalavra(@PathVariable Long wordId) {

        return ResponseEntity.ok(wordTagService.getTagsPorPalavra(wordId));
    }
}
