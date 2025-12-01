package com.gft.ms_relationship_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "tb_relationship",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"word_id", "tag_id"})
        })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WordTagRelationship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "word_id", nullable = false)
    private Long wordId;

    @Column(name = "tag_id", nullable = false)
    private Long tagId;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        WordTagRelationship that = (WordTagRelationship) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
