package com.example.ppvisl3;

import android.content.Intent;
import android.view.View;

import com.example.ppvisl3.Services.Model.DebitCard;
import com.example.ppvisl3.View.CheckAccountBalanceActivity;
import com.example.ppvisl3.View.PutMoneyActivity;
import com.example.ppvisl3.View.WithdrawActivity;

public class MenuViewModel {

    public static final String DEBIT_CARD_INTENT_EXTRA = "CARD_EXTRA";
    private DebitCard mDebitCard;

    public MenuViewModel(DebitCard debitCard) {
        mDebitCard = debitCard;
    }

    public void onWithdrawClick(View view){
        Intent intent = new Intent(view.getContext(), WithdrawActivity.class);
        intent.putExtra(DEBIT_CARD_INTENT_EXTRA, mDebitCard);
        view.getContext().startActivity(intent);
    }

    public void onCheckClick(View view){
        Intent intent = new Intent(view.getContext(), CheckAccountBalanceActivity.class);
        intent.putExtra(DEBIT_CARD_INTENT_EXTRA, mDebitCard);
        view.getContext().startActivity(intent);
    }

    public void onPutMoneyClick(View view){
        Intent intent = new Intent(view.getContext(), PutMoneyActivity.class);
        intent.putExtra(DEBIT_CARD_INTENT_EXTRA, mDebitCard);
        view.getContext().startActivity(intent);
    }

    public void onTransferClick(View view){
        Intent intent = new Intent();
        intent.putExtra(DEBIT_CARD_INTENT_EXTRA, mDebitCard);
        //TODO
    }
}
