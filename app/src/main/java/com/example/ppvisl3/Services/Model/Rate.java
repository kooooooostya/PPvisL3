package com.example.ppvisl3.Services.Model;

//The following class introduce rate in constant values
public class Rate {
    private double mRateUSD;
    private double mRateBY;
    private double mRateRUB;

    public Rate() {
        updateRate();
    }

    private void updateRate() {
        mRateUSD = 1;
        mRateBY = 2.6;
        mRateRUB = 75;
    }

    public double getRateUSD() {
        return mRateUSD;
    }

    public double getRateBY() {
        return mRateBY;
    }

    public double getRateRUB() {
        return mRateRUB;
    }
}
