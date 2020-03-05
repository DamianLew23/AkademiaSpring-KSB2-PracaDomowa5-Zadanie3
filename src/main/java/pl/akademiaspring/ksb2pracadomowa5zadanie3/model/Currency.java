package pl.akademiaspring.ksb2pracadomowa5zadanie3.model;

import java.math.BigDecimal;

public class Currency {
    private String code;
    private BigDecimal value;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "code='" + code + '\'' +
                ", value=" + value +
                '}';
    }
}
