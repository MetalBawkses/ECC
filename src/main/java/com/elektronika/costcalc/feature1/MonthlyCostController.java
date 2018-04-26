package com.elektronika.costcalc.feature1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;

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
        monthlyCostService.costsByType();

        HashMap<Integer, Float> result = monthlyCostService.calculateMonthlyCostsForLedgerNumbers(201801);
        model.addAttribute("monthlyCosts", result);
        return "index";
    }

}
