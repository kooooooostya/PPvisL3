package com.example.ppvisl3;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Toast;
import com.example.ppvisl3.Services.Model.DebitCard;
import com.example.ppvisl3.Services.Model.Money;

public class PutMoneyViewModel extends WithdrawViewModel{

    public PutMoneyViewModel(DebitCard debitCard) {
        super(debitCard);
    }

    @Override
    public void onClick(View view) {
        SharedPreferences.Editor editor = view.getContext().getSharedPreferences(
                StartScreenViewModel.SHARED_PREFERENCES, Context.MODE_PRIVATE).edit();
        String pathInSharedPreferences = "";
        switch (mDebitCard.getMoney().getCurrency()){
            case Money.USD:
                pathInSharedPreferences = StartScreenViewModel.SP_CARD1_VALUE;
                break;
            case Money.BY:
                pathInSharedPreferences = StartScreenViewModel.SP_CARD2_VALUE;
                break;
            case Money.RUB:
                pathInSharedPreferences = StartScreenViewModel.SP_CARD3_VALUE;
                break;
        }
        switch (view.getId()){
            case R.id.button5p:
                super.mDebitCard.putMoneyToCard(new Money(Money.BY, 5));
                break;
            case R.id.button10p:
                super.mDebitCard.putMoneyToCard(new Money(Money.BY, 10));
                break;
            case R.id.button20p:
                super.mDebitCard.putMoneyToCard(new Money(Money.BY, 20));
                break;
            case R.id.button50p:
                super.mDebitCard.putMoneyToCard(new Money(Money.BY, 50));
                break;
            case R.id.button100p:
                super.mDebitCard.putMoneyToCard(new Money(Money.BY, 100));
                break;
            case R.id.button500p:
                super.mDebitCard.putMoneyToCard(new Money(Money.BY, 500));
                break;
        }
        editor.putFloat(pathInSharedPreferences, (float)mDebitCard.getMoney().getValue());
        editor.apply();
        Toast.makeText(view.getContext(), "Успех", Toast.LENGTH_LONG).show();
        onCreateDialog(view);
    }
}
