package com.example.ppvisl3.Services.Model;

public class CardNumber {
    private final long mCardNumber;
    private static long sLastCardNumber = 1000000000000000L;

    public CardNumber() {
        mCardNumber = sLastCardNumber++;
        sLastCardNumber++;
    }

    public long getCardNumber() {
        return mCardNumber;
    }

    @Override
    public String toString() {
        return String.valueOf(mCardNumber);
    }
}

