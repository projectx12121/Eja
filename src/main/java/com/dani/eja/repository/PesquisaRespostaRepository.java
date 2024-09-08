package com.dani.eja.repository;

import org.springframework.data.domain.Pageable;
//import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.dani.eja.model.PesquisaResposta;
import java.util.List;


public interface PesquisaRespostaRepository extends JpaRepository<PesquisaResposta, Long> {
        @Query("SELECT p.comunidade.nome, COUNT(p) FROM PesquisaResposta p GROUP BY p.comunidade.nome ORDER BY COUNT(p) DESC")
        List<Object[]> countByComunidade();

        @Query("SELECT COUNT(p) FROM PesquisaResposta p WHERE p.interesseVoltarEstudar = true")
        Long countByInteresseVoltarEstudar();

        @Query("SELECT p.grauEscolaridade, COUNT(p) AS qtde " +
        "FROM PesquisaResposta p " +
        "GROUP BY p.grauEscolaridade " +
        "ORDER BY qtde DESC")
        List<Object[]> findTopGrauEscolaridade(Pageable pageable);

        @Query("SELECT p.comunidade.nome, " +
        "SUM(CASE WHEN p.idade BETWEEN 15 AND 29 THEN 1 ELSE 0 END) AS faixa15_29, " +
        "SUM(CASE WHEN p.idade BETWEEN 30 AND 49 THEN 1 ELSE 0 END) AS faixa30_49, " +
        "SUM(CASE WHEN p.idade BETWEEN 50 AND 99 THEN 1 ELSE 0 END) AS faixa50_99 " +
        "FROM PesquisaResposta p " +
        "GROUP BY p.comunidade.nome")
        List<Object[]> findQuantidadePorFaixaEtariaPorComunidade();

        @Query("SELECT p.comunidade.nome AS comunidade, p.grauEscolaridade AS escolaridade, COUNT(p) AS quantidade " +
                "FROM PesquisaResposta p " +
                "GROUP BY p.comunidade.nome, p.grauEscolaridade " +
                "ORDER BY p.comunidade.nome")
        List<Object[]> findQuantidadePorEscolaridadePorComunidade();
        @Query("SELECT " +
        "CASE WHEN m.idade BETWEEN 15 AND 29 THEN '15-29' " +
        "     WHEN m.idade BETWEEN 30 AND 49 THEN '30-49' " +
        "     WHEN m.idade BETWEEN 50 AND 69 THEN '50-69' " +
        "     WHEN m.idade >= 70 THEN 'Acima de 70' " +
        "END AS faixaEtaria, " +
        "COUNT(m) AS quantidade " +
        "FROM PesquisaResposta m " + // Adicionado espaço antes de 'FROM'
        "GROUP BY " +
        "CASE WHEN m.idade BETWEEN 15 AND 29 THEN '15-29' " +
        "     WHEN m.idade BETWEEN 30 AND 49 THEN '30-49' " +
        "     WHEN m.idade BETWEEN 50 AND 69 THEN '50-69' " +
        "     WHEN m.idade >= 70 THEN 'Acima de 70' " +
        "END " +
        "ORDER BY faixaEtaria")
        List<Object[]> findFaixaEtariaTodasComunidades();
 
 

}


