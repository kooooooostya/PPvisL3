package com.example.ppvisl3.View;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.ppvisl3.MenuViewModel;
import com.example.ppvisl3.R;
import com.example.ppvisl3.Services.Model.DebitCard;
import com.example.ppvisl3.StartScreenViewModel;
import com.example.ppvisl3.databinding.ActivityMenuBinding;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMenuBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_menu);
        DebitCard debitCard = getIntent().getParcelableExtra(StartScreenViewModel.DEBIT_CARD_INTENT_EXTRA);
        binding.setViewModel(new MenuViewModel(debitCard));
    }
}