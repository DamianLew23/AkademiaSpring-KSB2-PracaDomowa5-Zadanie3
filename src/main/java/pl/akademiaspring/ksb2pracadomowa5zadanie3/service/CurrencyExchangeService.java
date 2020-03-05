package pl.akademiaspring.ksb2pracadomowa5zadanie3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.akademiaspring.ksb2pracadomowa5zadanie3.client.CurrencyExchangeClient;
import pl.akademiaspring.ksb2pracadomowa5zadanie3.model.Currency;
import pl.akademiaspring.ksb2pracadomowa5zadanie3.model.CurrencyExchange;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

@Service
public class CurrencyExchangeService {

    private CurrencyExchange currencyExchange;

    @Autowired
    CurrencyExchangeService(
            CurrencyExchangeClient currencyExchangeClient
    ) {
        this.currencyExchange = currencyExchangeClient.getCurrencyExchange();
    }

    public Currency getRandomCurrency() {

        Map<String, String> currenciesRates = currencyExchange.getRates();
        Set<String> countryCodesSet = currenciesRates.keySet();
        String[] countryCodesArray = new String[countryCodesSet.size()];
        countryCodesArray = countryCodesSet.toArray(countryCodesArray);

        Random random = new Random();

        Integer randomCountryCodeIndex = random.nextInt(countryCodesArray.length);

        String randomCountryCode = countryCodesArray[randomCountryCodeIndex];

        String randomCurrencyRate = currenciesRates.get(randomCountryCode);

        Currency randomCurrency = new Currency();
        randomCurrency.setCode(randomCountryCode);
        randomCurrency.setValue(new BigDecimal(randomCurrencyRate).setScale(2, RoundingMode.HALF_EVEN));

        return randomCurrency;
    }


}
