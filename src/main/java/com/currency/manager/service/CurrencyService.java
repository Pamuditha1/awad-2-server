package com.currency.manager.service;

import java.util.List;

import com.currency.manager.model.Currency;

public interface CurrencyService
{
    Currency addCurrency(Currency currency);
    List<Currency> getAllCurrency();
}
