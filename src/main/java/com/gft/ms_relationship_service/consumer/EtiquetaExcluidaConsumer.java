package com.gft.ms_relationship_service.consumer;

import com.gft.ms_relationship_service.dto.EtiquetaExcluidaMensage;
import com.gft.ms_relationship_service.service.WordTagService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class EtiquetaExcluidaConsumer implements IEtiquetaExcluidaConsumer {

    private final WordTagService wordTagService;


    @RabbitListener(queues = "${spring.rabbitmq.queue.tag.name}")
    @Override
    public void receive(EtiquetaExcluidaMensage mensage) {
        log.info("📩 [RabbitMQ] Mensagem recebida no consumer: {}", mensage);
        wordTagService.removerPorTagId(mensage.getIdEtiqueta());


    }



}
