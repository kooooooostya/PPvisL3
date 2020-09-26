package com.example.ppvisl3;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;

import com.example.ppvisl3.Services.Model.CardNumber;
import com.example.ppvisl3.Services.Model.DebitCard;
import com.example.ppvisl3.Services.Model.Money;
import com.example.ppvisl3.View.VerifyPasswordActivity;

public class StartScreenViewModel {

    public static final String SHARED_PREFERENCES = "debit card preferences";
    public static final String SP_CARD1_VALUE = "card1";
    public static final String SP_CARD2_VALUE = "card2";
    public static final String SP_CARD3_VALUE = "card3";

    public static final String DEBIT_CARD_INTENT_EXTRA = "CARD_EXTRA";
    DebitCard mDebitCard1;
    DebitCard mDebitCard2;
    DebitCard mDebitCard3;

    //initializes debitCards, and if a value is stored in sharedPreferences, sets the value for the debit card
    public StartScreenViewModel(Context context) {

        mDebitCard1 = updateAndGetDebitCard1(context);

        mDebitCard2 = updateAndGetDebitCard2(context);

        mDebitCard3 = updateAndGetDebitCard3(context);
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

    public void onCardClick(View view){
        Intent intent = new Intent(view.getContext(), VerifyPasswordActivity.class);
        switch (view.getId()){
            case R.id.start_card_view_1:
                intent.putExtra(DEBIT_CARD_INTENT_EXTRA, mDebitCard1);
                break;
            case R.id.start_card_view_2:
                intent.putExtra(DEBIT_CARD_INTENT_EXTRA, mDebitCard2);
                break;
            case R.id.start_card_view_3:
                intent.putExtra(DEBIT_CARD_INTENT_EXTRA, mDebitCard3);
                break;
        }
        view.getContext().startActivity(intent);
    }

    //returns mDebitCard1 and update value if it change
    public DebitCard updateAndGetDebitCard1(Context context) {
        mDebitCard1 = new DebitCard(new CardNumber(1000000000000000L), 1111, Money.USD);
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);
        float aFloat = sharedPreferences.getFloat(SP_CARD1_VALUE, -1);
        if(aFloat != -1) {
            mDebitCard1.setMoney(new Money(mDebitCard1.getMoney().getCurrency(), aFloat));
        }else {
            mDebitCard1.putMoneyToCard(new Money(Money.BY, 1000));
        }
        return mDebitCard1;
    }
    //creates mDebitCard2 and update value of count Money if it change
    public DebitCard updateAndGetDebitCard2(Context context) {
        mDebitCard2 = new DebitCard(new CardNumber(1000000000000001L), 2222, Money.BY);
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);
        float aFloat = sharedPreferences.getFloat(SP_CARD2_VALUE, -1);
        if(aFloat != -1) {
            mDebitCard2.setMoney(new Money(mDebitCard2.getMoney().getCurrency(), aFloat));
        }else mDebitCard2.putMoneyToCard(new Money(Money.USD, 100));

        return mDebitCard2;
    }
    //returns mDebitCard3 and update value of count Money if it change
    public DebitCard updateAndGetDebitCard3(Context context) {
        mDebitCard3 = new DebitCard(new CardNumber(1000000000000002L), 3333, Money.RUB);
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);
        float aFloat = sharedPreferences.getFloat(SP_CARD3_VALUE, -1);
        if(aFloat != -1) {
            mDebitCard3.setMoney(new Money(mDebitCard3.getMoney().getCurrency(), aFloat));
        }else mDebitCard3.putMoneyToCard(new Money(Money.USD, 500));
        return mDebitCard3;
    }
}
