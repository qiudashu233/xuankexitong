package com.example.xuankexitong.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ShouyeViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public ShouyeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("首页界面，使用viewmodel储存");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
