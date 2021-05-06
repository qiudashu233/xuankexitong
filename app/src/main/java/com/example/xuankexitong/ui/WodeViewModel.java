package com.example.xuankexitong.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WodeViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public WodeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("我的界面，使用viewmodel储存");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
