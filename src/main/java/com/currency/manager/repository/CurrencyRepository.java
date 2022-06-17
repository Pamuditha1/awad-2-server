package com.currency.manager.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.currency.manager.model.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, Long>
{
}
