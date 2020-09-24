package com.example.ppvisl3.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.ppvisl3.R;
import com.example.ppvisl3.Services.Model.DebitCard;
import com.example.ppvisl3.StartScreenViewModel;
import com.example.ppvisl3.databinding.ActivityVerifyPasswordBinding;

public class VerifyPasswordActivity extends AppCompatActivity {

    private DebitCard mDebitCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityVerifyPasswordBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_verify_password);
        mDebitCard = getIntent().getParcelableExtra(StartScreenViewModel.DEBIT_CARD_INTENT_EXTRA);

        binding.verifyPasswordB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDebitCard.checkPassword(binding.verifyPasswordEt.getText().toString())){
                    Intent intent;
                    //TODO Перезод к меню выбора действий
                }
                else {
                    binding.verifyPasswordEt.setText("");
                    binding.verifyPasswordEt.setHint(R.string.et_hint_wrong_password);
                }
            }
        });
    }


}