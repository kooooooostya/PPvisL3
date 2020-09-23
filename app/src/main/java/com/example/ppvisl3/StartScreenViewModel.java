package com.example.ppvisl3;
import android.content.Intent;

import com.example.ppvisl3.Services.Model.CardNumber;
import com.example.ppvisl3.Services.Model.DebitCard;
import com.example.ppvisl3.Services.Model.Money;

public class StartScreenViewModel {

    DebitCard mDebitCard1;
    DebitCard mDebitCard2;
    DebitCard mDebitCard3;

    public StartScreenViewModel() {
        mDebitCard1 = new DebitCard(new CardNumber(), 1111, Money.USD);
        mDebitCard1.putMoneyToCard(new Money(Money.BY, 1000));

        mDebitCard2 = new DebitCard(new CardNumber(), 2222, Money.BY);
        mDebitCard2.putMoneyToCard(new Money(Money.USD, 100));

        mDebitCard3 = new DebitCard(new CardNumber(), 3333, Money.RUB);
        mDebitCard3.putMoneyToCard(new Money(Money.USD, 500));
    }

    public String getCardNumber1(){
        return mDebitCard1.getCardNumber().toString();
    }
    public String getCardNumber2(){
        return mDebitCard2.getCardNumber().toString();
    }
    public String getCardNumber3(){
        return mDebitCard3.getCardNumber().toString();
    }

    public void onFirstCardClick(){
        Intent intent = new Intent();
    }
    public void onSecondCardClick(){
        Intent intent = new Intent();
    }
    public void onThirdCardClick(){
        Intent intent = new Intent();
    }
}
