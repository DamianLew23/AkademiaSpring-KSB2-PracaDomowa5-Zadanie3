package pl.akademiaspring.ksb2pracadomowa5zadanie3.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import pl.akademiaspring.ksb2pracadomowa5zadanie3.model.CurrencyExchange;

@Controller
public class CurrencyExchangeClient {



    public CurrencyExchange getCurrencyExchange() {
        RestTemplate restTemplate = new RestTemplate();
        CurrencyExchange currencyExchange = restTemplate.getForObject("https://api.exchangeratesapi.io/latest?base=PLN", CurrencyExchange.class);
        return currencyExchange;
    }
}
