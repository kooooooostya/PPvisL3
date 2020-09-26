package com.example.ppvisl3;

import android.content.Intent;
import android.view.View;

import com.example.ppvisl3.Services.Model.DebitCard;
import com.example.ppvisl3.View.TransferSelectCountActivity;

public class TransferViewModel extends StartScreenViewModel {

    private DebitCard mDebitCard;
    public static final String EXTRA_DEBIT_CARD_INTENT_EXTRA = "CARD_EXTRA_EXTRA";

    public TransferViewModel(DebitCard debitCard) {
        mDebitCard = debitCard;
    }

    @Override
    public void onCardClick(View view) {

        Intent intent = new Intent(view.getContext(), TransferSelectCountActivity.class);
        switch (view.getId()) {
            case R.id.start_card_view_1:
                intent.putExtra(DEBIT_CARD_INTENT_EXTRA, mDebitCard);
                intent.putExtra(EXTRA_DEBIT_CARD_INTENT_EXTRA, mDebitCard1);
                break;
            case R.id.start_card_view_2:
                intent.putExtra(DEBIT_CARD_INTENT_EXTRA, mDebitCard);
                intent.putExtra(EXTRA_DEBIT_CARD_INTENT_EXTRA, mDebitCard2);
                break;
            case R.id.start_card_view_3:
                intent.putExtra(DEBIT_CARD_INTENT_EXTRA, mDebitCard);
                intent.putExtra(EXTRA_DEBIT_CARD_INTENT_EXTRA, mDebitCard3);
                break;
        }
        view.getContext().startActivity(intent);
    }
}
