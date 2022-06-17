package com.currency.manager.service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.currency.manager.model.Currency;
import com.currency.manager.repository.CurrencyRepository;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CurrencyServiceImpl implements CurrencyService
{
    private final CurrencyRepository currencyRepository;

//    public CurrencyServiceImpl(CurrencyRepository currencyRepository) {
//        this.currencyRepository = currencyRepository;
//    }

    @Override
    public Currency addCurrency( Currency currency )
    {
        // log.info("Saving currency value {} to the database");
        return currencyRepository.save(currency);
    }

    @Override
    public List<Currency> getAllCurrency()
    {
        // log.info("Getting all the currency values from the database");
        return currencyRepository.findAll(Sort.by(Sort.Direction.DESC, "date"));
    }
}
