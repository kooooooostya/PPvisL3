package com.example.ppvisl3;

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
        Toast.makeText(view.getContext(), "Успех", Toast.LENGTH_LONG).show();
        onCreateDialog(view);
    }
}
