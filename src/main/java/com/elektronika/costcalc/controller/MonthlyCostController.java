package com.elektronika.costcalc.controller;

import com.elektronika.costcalc.model.LeaseWorkCost;
import com.elektronika.costcalc.model.MaterialCost;
import com.elektronika.costcalc.model.WorkCost;
import com.elektronika.costcalc.repository.CostRepository;
import com.elektronika.costcalc.repository.LedgerNumberRepository;
import com.elektronika.costcalc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

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
        ArrayList<Object> costClassList = new ArrayList<>();

        costClassList.add(MaterialCost.class);
        costClassList.add(LeaseWorkCost.class);
        costClassList.add(WorkCost.class);



        model.addAttribute("newTable", monthlyCostService.createMapOfCostList(201801));

        model.addAttribute("monthlyCostTable",monthlyCostService.monthlyCostCalculator(201801, costClassList));

        return "index";
    }

}
