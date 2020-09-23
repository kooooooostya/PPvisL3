package com.example.ppvisl3.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class PurseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        FragmentPurseBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_purse, container, false);
//        binding.setViewModel(new PurseViewModel());
//       // binding.purseRecyclerView.setLayoutManager(new GridLayoutManager());
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}