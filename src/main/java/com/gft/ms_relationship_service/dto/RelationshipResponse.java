package com.gft.ms_relationship_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RelationshipResponse {
    private Long id;
    private Long wordId;
    private Long tagId;
}
