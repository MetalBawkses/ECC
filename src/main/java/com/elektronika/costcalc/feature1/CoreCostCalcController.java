package com.elektronika.costcalc.feature1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CoreCostCalcController {

    @Autowired
    CostRepository costRepository;

    @GetMapping("/")
    public String index(Model model){
        List<Cost> result = costRepository.findAllCost(201801);

        model.addAttribute("costList", result);
        return "index";
    }

}
