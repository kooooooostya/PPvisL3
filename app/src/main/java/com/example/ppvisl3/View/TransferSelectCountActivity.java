package com.example.ppvisl3.View;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.ppvisl3.R;
import com.example.ppvisl3.Services.Model.DebitCard;
import com.example.ppvisl3.TransferSelectCountViewModel;
import com.example.ppvisl3.TransferViewModel;
import com.example.ppvisl3.databinding.ActivityWithdrawBinding;

public class TransferSelectCountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityWithdrawBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_withdraw);
        binding.setViewModel(new TransferSelectCountViewModel((DebitCard) getIntent().
                getParcelableExtra(TransferViewModel.DEBIT_CARD_INTENT_EXTRA),
                        (DebitCard)getIntent().getParcelableExtra(TransferViewModel.EXTRA_DEBIT_CARD_INTENT_EXTRA)
                ));

        super.onCreate(savedInstanceState);
    }
}