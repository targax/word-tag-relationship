package com.gft.ms_relationship_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RelationshipSimpleResponse {
    private Long id;
    private String termo;
    private String tag;
}
