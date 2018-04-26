package com.elektronika.costcalc.controller;

import com.elektronika.costcalc.repository.CostRepository;
import com.elektronika.costcalc.repository.LedgerNumberRepository;
import com.elektronika.costcalc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MonthlyCostController {

    @Autowired
    CostRepository costRepository;

    @Autowired
    LedgerNumberRepository ledgerNumberRepository;

    @Autowired
    MonthlyCostService monthlyCostService;

    @GetMapping("/")
    public String index(Model model){

        monthlyCostService.mergeCostMaps();
        model.addAttribute("finalTable", monthlyCostService.mergeCostMaps());

        return "index";
    }

}
