package com.gft.ms_relationship_service.service;

import com.gft.ms_relationship_service.client.TagClient;
import com.gft.ms_relationship_service.client.WordClient;
import com.gft.ms_relationship_service.dto.*;
import com.gft.ms_relationship_service.entity.WordTagRelationship;
import com.gft.ms_relationship_service.exception.EtiquetaNaoEncontradaException;
import com.gft.ms_relationship_service.exception.PalavraNaoEncontradaException;
import com.gft.ms_relationship_service.repository.WordTagRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class WordTagService {

    private final WordTagRepository wordTagRepository;
    private final WordClient wordClient;
    private final TagClient tagClient;

    public WordTagService(WordTagRepository wordTagRepository, WordClient wordClient, TagClient tagClient) {
        this.wordTagRepository = wordTagRepository;
        this.wordClient = wordClient;
        this.tagClient = tagClient;
    }

    public WordTagRelationship create(CreateRelationshipRequest request){

        if (!palavraExiste(request.getWordId())) {
            throw new PalavraNaoEncontradaException(request.getWordId());
        }

        if (!etiquetaExiste(request.getTagId())) {
            throw new EtiquetaNaoEncontradaException(request.getTagId());
        }

        WordTagRelationship relationship = new WordTagRelationship();
        relationship.setWordId(request.getWordId());
        relationship.setTagId(request.getTagId());

        return wordTagRepository.save(relationship);
    }

    private boolean palavraExiste(Long id) {
        try {
            return wordClient.verificaPalavra(id).getStatusCode().is2xxSuccessful();
        } catch (Exception e) {
            return false;
        }
    }

    private boolean etiquetaExiste(Long id) {
        try {
            return tagClient.verificaTag(id).getStatusCode().is2xxSuccessful();
        } catch (Exception e) {
            return false;
        }
    }

    public List<PalavraRelacionadaResponse> getPalavrasPorTag(Long tagId) {

        return wordTagRepository.findByTagId(tagId).stream()
                .map(rel -> {
                    WordResponse word = wordClient.getWord(rel.getWordId());
                    return new PalavraRelacionadaResponse(word.getId(), word.getTermo());
                })
                .toList();
    }


    public List<TagRelacionadaResponse> getTagsPorPalavra(Long wordId) {

        return wordTagRepository.findByWordId(wordId).stream()
                .map(rel -> {
                    TagResponse tag = tagClient.getTag(rel.getTagId());
                    return new TagRelacionadaResponse(tag.getId(), tag.getName());
                })
                .toList();
    }




    public void removerPorTagId(Long tagId) {

        List<WordTagRelationship> relacionamentos =
                wordTagRepository.findByTagId(tagId);

        if (relacionamentos.isEmpty()) {
            log.info("⚠️ Nenhum relacionamento encontrado para tagId={}", tagId);
            return;
        }

        wordTagRepository.deleteAll(relacionamentos);

        log.info("🧹 Remoção concluída! 🗑️ {} relacionamentos excluídos para tagId={}",
                relacionamentos.size(), tagId);


    }


    public void  removerPorWordId(Long wordId){

        List<WordTagRelationship> relacoes = wordTagRepository.findByWordId(wordId);

        if (relacoes.isEmpty()) {
            log.info("⚠️ Nenhum relacionamento encontrado para wordId={}", wordId);
            return;
        }

        wordTagRepository.deleteAll(relacoes);

        log.info("🧹 Remoção concluída! 🗑️ {} relacionamentos excluídos para wordId={}",
                relacoes.size(), wordId);

    }


    public void delete(Long id){
        WordTagRelationship response=wordTagRepository.findById(id).orElseThrow(() -> new RuntimeException("id não encontrado"));
        wordTagRepository.deleteById(id);
    }


}
