package com.elektronika.costcalc.controller;


import com.elektronika.costcalc.repository.CostRepository;
import com.elektronika.costcalc.repository.LedgerNumberRepository;
import com.elektronika.costcalc.service.*;
import com.elektronika.costcalc.util.CostList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

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
        HashMap<Integer, CostList> mapForModel = monthlyCostService.createMapOfCostList(201801);
        List<String> listOfLedgerNumbersString = new ArrayList<>();
        List<Integer> listOfLedgerNumbersInt = new ArrayList<>();
        for(Map.Entry<Integer, CostList> entry : mapForModel.entrySet()){
            listOfLedgerNumbersString.add(entry.getKey().toString());
        }

        Collections.sort(listOfLedgerNumbersString);
        for (String number: listOfLedgerNumbersString) {
            listOfLedgerNumbersInt.add(Integer.parseInt(number));
        }
            model.addAttribute("ledgerNumbersSorted", listOfLedgerNumbersInt);
            model.addAttribute("mapForModel", mapForModel);
        return "index";
    }

}
