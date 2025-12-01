package com.gft.ms_relationship_service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateRelationshipRequest {

    @NotNull(message = "wordId é obrigatório")
    private Long wordId;

    @NotNull(message = "tagId é obrigatório")
    private Long tagId;
}
