package com.gft.ms_relationship_service.exception;

public class RelationshipNotFoundException extends RuntimeException {
    public RelationshipNotFoundException(Long id) {
        super("Relacionamento não encontrado: " + id);
    }
}
