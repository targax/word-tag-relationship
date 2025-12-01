package com.gft.ms_relationship_service.exception;

public class EtiquetaNaoEncontradaException extends RuntimeException {
    public EtiquetaNaoEncontradaException(Long id) {
        super("Etiqueta não encontrada: " + id);
    }
}
