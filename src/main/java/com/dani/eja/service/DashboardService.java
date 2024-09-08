package com.dani.eja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import com.dani.eja.repository.PesquisaRespostaRepository;
import org.springframework.data.domain.Pageable;

@Service
public class DashboardService {
      @Autowired
    private PesquisaRespostaRepository pesquisaRespostaRepository;

    public List<Object[]> findAllRespostas() {
        return pesquisaRespostaRepository.countByComunidade();
    }  

    public long getTotalEntrevistados() {
        return pesquisaRespostaRepository.count();
    }  

    public long getTotalIntereVoltarEstudar() {
        return pesquisaRespostaRepository.countByInteresseVoltarEstudar();
    }  

    public Object[] getMaxEscolaridade() {
        Pageable pageable = PageRequest.of(0, 1); // Página 0, tamanho 1
        List<Object[]> result = pesquisaRespostaRepository.findTopGrauEscolaridade(pageable);
        if (!result.isEmpty()) {
            return result.get(0);
        } else {
            // Retorne um valor padrão se não houver resultados
            return new Object[]{"N/A", 0};
        }
    }  

    public List<Object[]> getQuantidadePorFaixaEtariaPorComunidade() {
        return pesquisaRespostaRepository.findQuantidadePorFaixaEtariaPorComunidade();
    }


    public List<Object[]> getQuantidadePorEscolaridadePorComunidade() {
        return pesquisaRespostaRepository.findQuantidadePorEscolaridadePorComunidade();
    }

    public List<Object[]> getFaixaEtariaTodasComunidades() {
        return pesquisaRespostaRepository.findFaixaEtariaTodasComunidades();
    }


}
