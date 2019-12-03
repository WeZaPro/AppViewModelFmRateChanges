package com.taweesak.appviewmodelfmratechange.Model;

import java.util.regex.Pattern;

public class Model {

    double rates;
    int choice;
    private String rateText;
    double ratesOriginalNumber;

    public Model(double rates, int choice) {
        //this.rates = rates;
        setRates(rates,choice);
        setRateText(choice);
        this.choice = choice;
        setRatesOriginalNumber(rates);
    }

    //ส่งข้อมูลต้นฉบับให้ editText ตอนทำ ViewModel เพราะต้องเป็นก่อนคำนวณ
    public double getRatesOriginalNumber() {
        return ratesOriginalNumber;
    }

    public void setRatesOriginalNumber(double ratesOriginalNumber) {
        this.ratesOriginalNumber = ratesOriginalNumber;
    }

    public String getRateText() {
        return rateText;
    }

    private void setRateText(int choice) {
        switch (choice) {
            case 0:
                this.rateText = "USD/THB";
                break;
            case 1:
                this.rateText = "JPY/THB";
                break;
            case 2:
                this.rateText = "EUR/THB";
                break;
        }
    }

    public double getRates() {
        return rates;
    }

    public void setRates(double rates, int choice) {
        switch (choice) {
            case 0:
                this.rates = rates * 30.0262;
                break;
            case 1:
                this.rates = rates * 27.3978;
                break;
            case 2:
                this.rates = rates * 33.2422;
                break;
        }
    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }
}
