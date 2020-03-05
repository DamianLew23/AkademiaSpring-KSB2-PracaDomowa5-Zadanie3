package pl.akademiaspring.ksb2pracadomowa5zadanie3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.akademiaspring.ksb2pracadomowa5zadanie3.model.Currency;

import java.math.BigDecimal;
import java.util.Scanner;

@Service
public class CurrencyGame {

    private CurrencyExchangeService currencyExchangeService;

    @Autowired
    CurrencyGame (
            CurrencyExchangeService currencyExchangeService
    ) {
        this.currencyExchangeService = currencyExchangeService;
    }


    @EventListener(ApplicationReadyEvent.class)
    public void startGame() {
        Currency randomCurrency = currencyExchangeService.getRandomCurrency();
        BigDecimal randomCurrencyValue = randomCurrency.getValue();

        System.out.println("Podaj aktualny kurs " + randomCurrency.getCode() + " uwzględniając 2 miejsca po przecinku.");

        BigDecimal currencyRateByUser;
        String currencyRateByUserText;
        Scanner scanner = new Scanner(System.in);
        boolean flag;
        int i = 1;

        do {
            do {
                currencyRateByUserText = scanner.nextLine();
                flag = currencyRateByUserText.matches("[0-9]+\\.[0-9]{2}");
                if (!flag) System.out.println("Niepoprawne dane!");
            } while (!flag);

            currencyRateByUser = new BigDecimal(currencyRateByUserText);

            if(currencyRateByUser.compareTo(randomCurrencyValue) == 1)
                System.out.println("Za dużo");
            if (currencyRateByUser.compareTo(randomCurrencyValue) == -1)
                System.out.println("Za mało");
            i++;

        } while (!currencyRateByUser.equals(randomCurrencyValue));

        if (currencyRateByUser.equals(randomCurrencyValue)) {
            System.out.println("Brawo! Udało się za " + i + " razem.");
        }
    }
}
