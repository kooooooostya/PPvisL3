package com.example.ppvisl3.Services.Model;


import java.util.Locale;

//The following class introduce money in one of three constant rates
public class Money {
    public static final String USD = "usd";
    public static final String BY = "by";
    public static final String RUB = "rub";

    private static Rate mRate;
    private String mCurrency;
    private double mValue;

    //default constructor, if 'currency' not from constant field, throws NPE
    public Money(String currency, double value) {
        if(!currency.equals(USD) && !currency.equals(BY) && !currency.equals(RUB)){
            throw new NullPointerException("Incorrect value \"currency\"");
        }
        mCurrency = currency;
        mValue = value;
        mRate = new Rate();
    }

    //transfer money from one currency to another, if newCurrency value incorrect throw NPE
    public void transferToAnotherCurrency(String newCurrency){
        double newRate, oldRate;
        switch (this.getCurrency()){
            case USD:
                oldRate = mRate.getRateUSD();
                break;
            case BY:
                oldRate = mRate.getRateBY();
                break;
            case RUB:
                oldRate = mRate.getRateRUB();
                break;
            default:throw new NullPointerException("field FROM in incorrect format");
        }
        switch (newCurrency){
            case USD:
                newRate = mRate.getRateUSD();
                this.mCurrency = USD;
                break;
            case BY:
                newRate = mRate.getRateBY();
                this.mCurrency = BY;
                break;
            case RUB:
                newRate = mRate.getRateRUB();
                this.mCurrency = RUB;
                break;
            default:throw new NullPointerException("field FROM in incorrect format");
        }
        this.mValue /= oldRate;
        this.mValue *= newRate;
    }

    public void addToTheAccount(double value, String currency){
        String oldCurrency = this.mCurrency;
        this.transferToAnotherCurrency(currency);
        this.setValue(this.getValue() + value);
        this.transferToAnotherCurrency(oldCurrency);
    }

    public void addToTheAccount(double value){
        this.setValue(this.getValue() + value);
    }

    // sets USD as the default currency
    public void setUSDCurrency(){
        transferToAnotherCurrency(USD);
    }
    // sets BY as the default currency
    public void setBYCurrency(){
        transferToAnotherCurrency(BY);
    }
    // sets RUB as the default currency
    public void setRUBCurrency(){
        transferToAnotherCurrency(RUB);
    }

    public void setValue(double value) {
        mValue = value;
    }

    public String getCurrency() {
        return mCurrency;
    }

    public double getValue() {
        return mValue;
    }

    @Override
    public String toString() {
        return String.format(Locale.getDefault(),"%.3f", mValue) + mCurrency;
    }
}
