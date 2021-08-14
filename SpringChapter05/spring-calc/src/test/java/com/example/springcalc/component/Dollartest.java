package com.example.springcalc.component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

@SpringBootTest
public class Dollartest {

    @MockBean
    private MarketApi marketApi;

    @Autowired
    private Calculator calculator;

    @Test
    public void dollarTest(){

        Mockito.when(marketApi.connect()).thenReturn(3000);
        int sum = calculator.sum(10, 10);
        int minus = calculator.minus(10, 10);

        Assertions.assertEquals(60000,sum);
        Assertions.assertEquals(0, minus);
    }


}
