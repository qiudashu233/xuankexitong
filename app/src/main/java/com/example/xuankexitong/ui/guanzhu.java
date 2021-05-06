package com.example.xuankexitong.ui;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xuankexitong.R;

public class guanzhu extends Fragment {

    private GuanzhuViewModel mViewModel;

    public static guanzhu newInstance() {
        return new guanzhu();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mViewModel =
                ViewModelProviders.of(this).get(GuanzhuViewModel.class);
        View root = inflater.inflate(R.layout.fra_guanzhu, container, false);
        final TextView textView = root.findViewById(R.id.text_guanzhu);
        mViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(GuanzhuViewModel.class);
        // TODO: Use the ViewModel
    }

}
