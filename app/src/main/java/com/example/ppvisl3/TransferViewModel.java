package com.example.ppvisl3;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.ppvisl3.Services.Model.DebitCard;
import com.example.ppvisl3.View.TransferSelectCountActivity;

public class TransferViewModel extends StartScreenViewModel {

    private DebitCard mDebitCard;
    public static final String EXTRA_DEBIT_CARD_INTENT_EXTRA = "CARD_EXTRA_EXTRA";

    public TransferViewModel(Context context, DebitCard debitCard) {
        super(context);
        mDebitCard = debitCard;
    }

    @Override
    public void onCardClick(View view) {

        Intent intent = new Intent(view.getContext(), TransferSelectCountActivity.class);
        switch (view.getId()) {
            case R.id.start_card_view_1:
                intent.putExtra(DEBIT_CARD_INTENT_EXTRA, mDebitCard);
                intent.putExtra(EXTRA_DEBIT_CARD_INTENT_EXTRA, updateAndGetDebitCard1(view.getContext()));
                break;
            case R.id.start_card_view_2:
                intent.putExtra(DEBIT_CARD_INTENT_EXTRA, mDebitCard);
                intent.putExtra(EXTRA_DEBIT_CARD_INTENT_EXTRA, updateAndGetDebitCard2(view.getContext()));
                break;
            case R.id.start_card_view_3:
                intent.putExtra(DEBIT_CARD_INTENT_EXTRA, mDebitCard);
                intent.putExtra(EXTRA_DEBIT_CARD_INTENT_EXTRA, updateAndGetDebitCard3(view.getContext()));
                break;
        }
        view.getContext().startActivity(intent);
    }
}
