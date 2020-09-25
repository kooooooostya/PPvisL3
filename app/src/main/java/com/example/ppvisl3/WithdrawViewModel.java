package com.example.ppvisl3;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.example.ppvisl3.Services.Model.DebitCard;
import com.example.ppvisl3.Services.Model.Money;
import com.example.ppvisl3.View.StartActivity;
import com.example.ppvisl3.View.VerifyPasswordActivity;

public class WithdrawViewModel {

    private DebitCard mDebitCard;

    public WithdrawViewModel(DebitCard debitCard) {
        mDebitCard = debitCard;
    }

    public void onClick(View view){
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
        }else Toast.makeText(view.getContext(), "Успех", Toast.LENGTH_LONG).show();
        onCreateDialog(view);
    }

    //Creates and show alertDialog
    public void onCreateDialog(final View view) {
        String title = "Продолжить?";
        final String message = "Желаете выполнить ещё операцию";
        String button1String = "Да";
        String button2String = "Нет";

        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setTitle(title);  // заголовок
        builder.setMessage(message); // сообщение
        builder.setPositiveButton(button1String, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent intent = new Intent(view.getContext(), VerifyPasswordActivity.class);
                intent.putExtra(StartScreenViewModel.DEBIT_CARD_INTENT_EXTRA, mDebitCard);
                view.getContext().startActivity(intent);
            }
        });
        builder.setNegativeButton(button2String, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent intent = new Intent(view.getContext(), StartActivity.class);
                intent.putExtra(StartScreenViewModel.DEBIT_CARD_INTENT_EXTRA, mDebitCard);
                view.getContext().startActivity(intent);
            }
        });
        builder.setCancelable(false);

        builder.create().show();
    }
}
