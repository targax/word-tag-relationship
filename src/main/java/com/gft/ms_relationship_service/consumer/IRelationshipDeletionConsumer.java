package com.gft.ms_relationship_service.consumer;

import com.gft.ms_relationship_service.dto.EtiquetaExcluidaMensage;

public interface IRelationshipDeletionConsumer {
    public void receive(EtiquetaExcluidaMensage mensage);
}
