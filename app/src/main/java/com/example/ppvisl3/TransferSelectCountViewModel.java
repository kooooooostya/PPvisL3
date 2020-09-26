package com.example.ppvisl3;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Toast;

import com.example.ppvisl3.Services.Model.DebitCard;
import com.example.ppvisl3.Services.Model.Money;

public class TransferSelectCountViewModel extends WithdrawViewModel{

    DebitCard mDebitCardTo;

    public TransferSelectCountViewModel(DebitCard from, DebitCard to) {
        super(from);
        mDebitCardTo = to;
    }

    @Override
    public void onClick(View view) {
        Money money;
        SharedPreferences.Editor editor = view.getContext().getSharedPreferences(
                StartScreenViewModel.SHARED_PREFERENCES, Context.MODE_PRIVATE).edit();
        String pathInSharedPreferencesFirstCard = "";
        //determines which currency in from DebitCard
        switch (mDebitCard.getMoney().getCurrency()){
            case Money.USD:
                pathInSharedPreferencesFirstCard = StartScreenViewModel.SP_CARD1_VALUE;
                break;
            case Money.BY:
                pathInSharedPreferencesFirstCard = StartScreenViewModel.SP_CARD2_VALUE;
                break;
            case Money.RUB:
                pathInSharedPreferencesFirstCard = StartScreenViewModel.SP_CARD3_VALUE;
                break;
        }
        String pathInSharedPreferencesSecondCard = "";
        //determines which currency in toDebitCard
        switch (mDebitCardTo.getMoney().getCurrency()){
            case Money.USD:
                pathInSharedPreferencesSecondCard = StartScreenViewModel.SP_CARD1_VALUE;
                break;
            case Money.BY:
                pathInSharedPreferencesSecondCard = StartScreenViewModel.SP_CARD2_VALUE;
                break;
            case Money.RUB:
                pathInSharedPreferencesSecondCard = StartScreenViewModel.SP_CARD3_VALUE;
                break;
        }

        switch (view.getId()){
            case R.id.button5p:
                money = mDebitCard.withdrawMoneyOrNull(5, Money.BY);
                break;
            case R.id.button10p:
                money = mDebitCard.withdrawMoneyOrNull(10, Money.BY);
                break;
            case R.id.button20p:
                money = mDebitCard.withdrawMoneyOrNull(20, Money.BY);
                break;
            case R.id.button50p:
                money = mDebitCard.withdrawMoneyOrNull(50, Money.BY);
                break;
            case R.id.button100p:
                money = mDebitCard.withdrawMoneyOrNull(100, Money.BY);
                break;
            case R.id.button500p:
                money = mDebitCard.withdrawMoneyOrNull(500, Money.BY);
                break;
            default:
                money = null;
        }

        if(money == null){
            Toast.makeText(view.getContext(), "На карте недостаточно средств", Toast.LENGTH_LONG).show();
        }else{
            editor.putFloat(pathInSharedPreferencesFirstCard, (float)mDebitCard.getMoney().getValue());
            mDebitCardTo.putMoneyToCard(money);
            editor.putFloat(pathInSharedPreferencesSecondCard, (float)mDebitCardTo.getMoney().getValue());
            Toast.makeText(view.getContext(), "Успех", Toast.LENGTH_LONG).show();
        }
        editor.apply();
        onCreateDialog(view);
    }
}
