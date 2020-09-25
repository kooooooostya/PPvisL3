package com.example.ppvisl3.View;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.ppvisl3.CheckBalanceViewModel;
import com.example.ppvisl3.R;
import com.example.ppvisl3.Services.Model.DebitCard;
import com.example.ppvisl3.StartScreenViewModel;
import com.example.ppvisl3.databinding.ActivityCheckAccountBalanceBinding;

public class CheckAccountBalanceActivity extends AppCompatActivity {

    private DebitCard mDebitCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDebitCard = (DebitCard) getIntent().getParcelableExtra(StartScreenViewModel.DEBIT_CARD_INTENT_EXTRA);
        ActivityCheckAccountBalanceBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_check_account_balance);
        binding.setViewModel(new CheckBalanceViewModel(mDebitCard));
    }

    @Override
    public void onBackPressed() {
        onCreateDialog(this, mDebitCard);
    }

    //Creates and show alertDialog
    public static void onCreateDialog(final Context context, final DebitCard debitCard) {
        String title = "Продолжить?";
        final String message = "Желаете выполнить ещё операцию";
        String button1String = "Да";
        String button2String = "Нет";

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);  // заголовок
        builder.setMessage(message); // сообщение
        builder.setPositiveButton(button1String, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent intent = new Intent(context, VerifyPasswordActivity.class);
                intent.putExtra(StartScreenViewModel.DEBIT_CARD_INTENT_EXTRA, debitCard);
                context.startActivity(intent);
            }
        });
        builder.setNegativeButton(button2String, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent intent = new Intent(context, StartActivity.class);
                intent.putExtra(StartScreenViewModel.DEBIT_CARD_INTENT_EXTRA, debitCard);
                context.startActivity(intent);
            }
        });
        builder.setCancelable(false);

        builder.create().show();
    }
}