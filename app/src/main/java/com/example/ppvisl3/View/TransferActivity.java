package com.example.ppvisl3.View;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.ppvisl3.R;
import com.example.ppvisl3.Services.Model.DebitCard;
import com.example.ppvisl3.StartScreenViewModel;
import com.example.ppvisl3.TransferViewModel;
import com.example.ppvisl3.databinding.StartScreenBinding;

public class TransferActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StartScreenBinding binding = DataBindingUtil.setContentView(this, R.layout.start_screen);
        binding.setViewModel(new TransferViewModel(getApplicationContext(),
                (DebitCard)getIntent().getParcelableExtra(StartScreenViewModel.DEBIT_CARD_INTENT_EXTRA)));
    }
}