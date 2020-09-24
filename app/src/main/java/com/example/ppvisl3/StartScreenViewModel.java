package com.example.ppvisl3;
import android.content.Intent;
import android.view.View;

import com.example.ppvisl3.Services.Model.CardNumber;
import com.example.ppvisl3.Services.Model.DebitCard;
import com.example.ppvisl3.Services.Model.Money;
import com.example.ppvisl3.View.VerifyPasswordActivity;

public class StartScreenViewModel {

    public static final String DEBIT_CARD_INTENT_EXTRA = "CARD_EXTRA";
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

    public void onFirstCardClick(View view){
        Intent intent = new Intent(view.getContext(), VerifyPasswordActivity.class);
        intent.putExtra(DEBIT_CARD_INTENT_EXTRA, mDebitCard1);
        view.getContext().startActivity(intent);

    }
    public void onSecondCardClick(View view){
        Intent intent = new Intent(view.getContext(), VerifyPasswordActivity.class);
        intent.putExtra(DEBIT_CARD_INTENT_EXTRA, mDebitCard1);
        view.getContext().startActivity(intent);
    }
    public void onThirdCardClick(View view){
        Intent intent = new Intent(view.getContext(), VerifyPasswordActivity.class);
        intent.putExtra(DEBIT_CARD_INTENT_EXTRA, mDebitCard1);
        view.getContext().startActivity(intent);
    }
}
