package com.example.ppvisl3;

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
            mDebitCardTo.putMoneyToCard(money);
            Toast.makeText(view.getContext(), "Успех", Toast.LENGTH_LONG).show();
        }
        onCreateDialog(view);
    }
}
