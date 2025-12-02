package com.gft.ms_relationship_service.consumer;

import com.gft.ms_relationship_service.dto.EtiquetaExcluidaMensage;
import com.gft.ms_relationship_service.dto.PalavraExcluidaMensage;

public interface IPalavraExcluidaConsumer {
    void receive(PalavraExcluidaMensage mensage);
}
