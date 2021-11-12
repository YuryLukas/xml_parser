package jl.narva.xml_parser;

public class ExchangeRates {
private String currency;
private String rate;

    public ExchangeRates(String currency, String rate) {
        this.currency = currency;
        this.rate = rate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
