package com.example.springcalc.controller;

import com.example.springcalc.component.Calculator;
import com.example.springcalc.component.ICalculator;
import com.example.springcalc.dto.Req;
import com.example.springcalc.dto.Res;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CalculatorApiController {

    private final Calculator calculator;

    @GetMapping("/sum")
    public int sum(@RequestParam int x, @RequestParam int y){
        return calculator.sum(x,y);
    }
//
//    @GetMapping("/minus")
//    public int minus(@RequestParam int x, @RequestParam int y){
//        return calculator.minus(x,y);
//    }


    @PostMapping("/minus")
    public Res minus(@RequestBody Req req){
        int result = calculator.minus(req.getX(), req.getY());

        Res res = new Res();
        res.setResult(result);
        res.setResponse(new Res.Body());
        return res;
    }
}
