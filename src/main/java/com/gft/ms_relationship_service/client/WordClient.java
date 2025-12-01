package com.gft.ms_relationship_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "word-service", url = "${services.word.url}")
public interface WordClient {

    @GetMapping("/palavras/existe/{id}")
    ResponseEntity<Void> verificaPalavra(@PathVariable Long id);
}
