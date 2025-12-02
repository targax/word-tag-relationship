package com.gft.ms_relationship_service.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    //<serviço>.<domínio>.<ação>.queue
    public static final String QUEUE_NAME_WORD = "word-service.word.excluida.queue";

    //<serviço>.<domínio>.<ação>.queue
    public static final String QUEUE_NAME_TAG = "tag-ms.etiqueta.excluida.queue";






    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }


    @Bean
    public RabbitTemplate rabbitTemplate(
            final ConnectionFactory connectionFactory,
            final Jackson2JsonMessageConverter converter){

        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);

        rabbitTemplate.setMessageConverter(converter);

        return rabbitTemplate;

    }

    // Criar Fila
    @Bean
    public Queue queueTag(){
        return new Queue(QUEUE_NAME_TAG,true);
    }

    @Bean
    public Queue queueWord(){
        return new Queue(QUEUE_NAME_WORD,true);
    }




}
