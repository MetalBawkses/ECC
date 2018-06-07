package com.elektronika.costcalc.controller;


import com.elektronika.costcalc.model.MaterialCost;
import com.elektronika.costcalc.repository.CostRepository;
import com.elektronika.costcalc.repository.LedgerNumberRepository;
import com.elektronika.costcalc.service.*;
import com.elektronika.costcalc.util.CostList;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@CrossOrigin
@Controller
public class MonthlyCostController {

    @Autowired
    CostRepository costRepository;

    @Autowired
    LedgerNumberRepository ledgerNumberRepository;

    @Autowired
    MonthlyCostService monthlyCostService;

    @Autowired
    MaterialCostService materialCostService;


    private final static String POST_CUSTOMER_URL = "/api/post/customer";
    private final static String CREATE_MATCOST_URL = "/api/post/newmatcost";



    @RequestMapping(value = "/lofasz", produces = "application/json")
    @ResponseBody
    public List lofasz(){
//        HashMap<Integer, CostList> mapForModel = monthlyCostService.createMapOfCostList(201801);
        List<CostList> returnList =  monthlyCostService.createMapOfCostList(201801);
        System.out.println("lofasz " + LocalDateTime.now());
        return returnList;
    }

    @PostMapping(POST_CUSTOMER_URL)
    public ResponseEntity<Integer> createCustomer(@RequestBody Integer testNumber) {

        System.out.println("Creat Customer: " + testNumber);

        return ResponseEntity.ok(testNumber);
    }

    @PostMapping(CREATE_MATCOST_URL)
    public ResponseEntity<JSONObject> createMatCost(@RequestBody JSONObject MatCosts) {

        System.out.println("Create Matcost: " + MatCosts);
        List<String> keyList = new ArrayList<>(MatCosts.keySet());
        System.out.println(keyList);
        for (String key: keyList) {
            System.out.println(MatCosts.get(key).getClass());
        }
        materialCostService.createMaterialCost((Integer)MatCosts.get("product"), BigDecimal.valueOf((Integer)MatCosts.get("matCostValue")),(Integer)MatCosts.get("yearMonth"), BigDecimal.valueOf((Integer)MatCosts.get("selfProducedMaterialCost")));
        return ResponseEntity.ok(MatCosts);
    }

    @GetMapping("/")
    public String index(Model model){
//        HashMap<Integer, CostList> mapForModel = monthlyCostService.createMapOfCostList(201801);
        List<String> listOfLedgerNumbersString = new ArrayList<>();
        List<Integer> listOfLedgerNumbersInt = new ArrayList<>();
//        for(Map.Entry<Integer, CostList> entry : mapForModel.entrySet()){
//            listOfLedgerNumbersString.add(entry.getKey().toString());
//        }

        Collections.sort(listOfLedgerNumbersString);
        for (String number: listOfLedgerNumbersString) {
            listOfLedgerNumbersInt.add(Integer.parseInt(number));
        }
        model.addAttribute("ledgerNumbersSorted", listOfLedgerNumbersInt);
//            model.addAttribute("mapForModel", mapForModel);
        return "index";
    }

}
