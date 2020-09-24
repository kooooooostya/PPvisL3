package com.example.ppvisl3;

import android.content.Intent;
import android.view.View;

import com.example.ppvisl3.Services.Model.DebitCard;

public class MenuViewModel {

    private DebitCard mDebitCard;

    public MenuViewModel(DebitCard debitCard) {
        mDebitCard = debitCard;
    }

    public void onWithdrawClick(View view){
        Intent intent = new Intent();
        //TODO 
    }
}
