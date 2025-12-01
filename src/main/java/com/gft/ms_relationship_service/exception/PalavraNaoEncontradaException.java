package com.gft.ms_relationship_service.exception;

public class PalavraNaoEncontradaException extends RuntimeException {
    public PalavraNaoEncontradaException(Long id) {
        super("Palavra não encontrada: " + id);
    }
}
