package com.gft.ms_relationship_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EtiquetaExcluidaMensage {

    private Long idEtiqueta;
    private Instant timestamp;
}