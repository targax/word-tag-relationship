package com.gft.ms_relationship_service.consumer;


import com.gft.ms_relationship_service.dto.PalavraExcluidaMensage;
import com.gft.ms_relationship_service.service.WordTagService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Slf4j
@Service
public class PalavraExcluidaConsumer implements IPalavraExcluidaConsumer{

    private  final WordTagService wordTagService;


    @RabbitListener(queues = "word-service.word.excluida.queue")
    @Override
    public void receive(PalavraExcluidaMensage mensage) {
        log.info("📩 [RabbitMQ] Mensagem recebida no consumer: {}", mensage);
        wordTagService.removerPorWordId(mensage.idPalavra());

    }
}
