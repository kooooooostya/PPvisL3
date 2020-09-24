package com.example.ppvisl3.View;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.ppvisl3.R;
import com.example.ppvisl3.Services.Model.DebitCard;
import com.example.ppvisl3.StartScreenViewModel;
import com.example.ppvisl3.WithdrawViewModel;
import com.example.ppvisl3.databinding.ActivityWithdrawBinding;

public class WithdrawActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityWithdrawBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_withdraw);
        binding.setViewModel(new WithdrawViewModel((DebitCard) getIntent().getParcelableExtra(StartScreenViewModel.DEBIT_CARD_INTENT_EXTRA)));
    }
}