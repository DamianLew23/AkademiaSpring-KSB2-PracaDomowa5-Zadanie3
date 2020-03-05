package pl.akademiaspring.ksb2pracadomowa5zadanie3.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "rates",
    "base",
    "date"
})
public class CurrencyExchange {

    @JsonProperty("rates")
    private Map<String, String> rates = new HashMap<>();
    @JsonProperty("base")
    private String base;
    @JsonProperty("date")
    private String date;

    @JsonProperty("rates")
    public Map<String, String> getRates() {
        return rates;
    }

    @JsonProperty("rates")
    public void setRates(Map<String, String> rates) {
        this.rates = rates;
    }

    @JsonProperty("base")
    public String getBase() {
        return base;
    }

    @JsonProperty("base")
    public void setBase(String base) {
        this.base = base;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CurrencyExchange{" +
                "rates=" + rates +
                ", base='" + base + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
