package com.gft.ms_relationship_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "tag-service", url = "${services.tag.url}")
public interface TagClient {

    @GetMapping("/tags/exists/{id}")
    ResponseEntity<Void> verificaTag(@PathVariable Long id);
}

