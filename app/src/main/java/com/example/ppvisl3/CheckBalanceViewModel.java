package com.example.ppvisl3;

import com.example.ppvisl3.Services.Model.DebitCard;

public class CheckBalanceViewModel {
    DebitCard mDebitCard;

    public CheckBalanceViewModel(DebitCard debitCard) {
        mDebitCard = debitCard;
    }

    public String getBalanceString(){
        return mDebitCard.getMoney().toString();
    }
}
