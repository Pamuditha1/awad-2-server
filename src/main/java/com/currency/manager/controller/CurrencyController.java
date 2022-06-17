package com.currency.manager.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.currency.manager.model.Currency;
import com.currency.manager.service.CurrencyService;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/currency")
@RequiredArgsConstructor
@Slf4j
public class CurrencyController
{
    private final CurrencyService currencyService;

//    public CurrencyController(CurrencyService currencyService) {
//        this.currencyService = currencyService;
//    }

    @GetMapping("/getAllCurrency")
    public ResponseEntity<List<Currency>> getAllCurrency(){
        return ResponseEntity.ok().body( currencyService.getAllCurrency() );
    }

    @PostMapping("/addCurrency")
    public ResponseEntity<Currency> addCurrency( @RequestBody Currency currency){
        log.info(currency.getTime());
        URI uri = URI.create( ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/currency/addCurrency").toUriString() );
        return ResponseEntity.created( uri ).body( currencyService.addCurrency(currency) );
    }
}
