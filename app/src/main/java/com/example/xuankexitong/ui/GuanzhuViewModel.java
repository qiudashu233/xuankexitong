package com.example.xuankexitong.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GuanzhuViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public GuanzhuViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("关注界面，使用viewmodel储存");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
