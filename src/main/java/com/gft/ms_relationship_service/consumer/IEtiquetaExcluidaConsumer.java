package com.gft.ms_relationship_service.consumer;

import com.gft.ms_relationship_service.dto.EtiquetaExcluidaMensage;

public interface IEtiquetaExcluidaConsumer {
    public void receive(EtiquetaExcluidaMensage mensage);
}
