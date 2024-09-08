package com.dani.eja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dani.eja.service.DashboardService;

@Controller
@RequestMapping("/api")
public class DashboardController {
    
    @Autowired
    private DashboardService dashboardService;

     @RequestMapping("/projeto")
    public String dashboard(Model model) {

        model.addAttribute("respostas", dashboardService.findAllRespostas());
        model.addAttribute("totalEntrevistados", dashboardService.getTotalEntrevistados());
        model.addAttribute("totalInteresse", dashboardService.getTotalIntereVoltarEstudar());
        model.addAttribute("maxQtdeEscolaridade", dashboardService.getMaxEscolaridade());

        List<Object[]> QtdeFaixaEtariaPorComunidade = dashboardService.getQuantidadePorFaixaEtariaPorComunidade();
        model.addAttribute("qtdeFaixaEtaria", QtdeFaixaEtariaPorComunidade);

        List<Object[]> QtdeEscolaridaComunidade = dashboardService.getQuantidadePorEscolaridadePorComunidade();
        model.addAttribute("qtdeEscolaridade", QtdeEscolaridaComunidade);

        List<Object[]> faixaEtariaTodasComunidades = dashboardService.getFaixaEtariaTodasComunidades();
        model.addAttribute("qtdeTotalFaixaEtaria", faixaEtariaTodasComunidades);
        
        return "dashboard";   // retorna o nome do template Thymeleaf, sem extensão
    }
    
}

