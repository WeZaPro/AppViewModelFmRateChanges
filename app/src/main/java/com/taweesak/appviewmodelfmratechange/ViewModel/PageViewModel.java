package com.taweesak.appviewmodelfmratechange.ViewModel;

import com.taweesak.appviewmodelfmratechange.Model.Model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PageViewModel extends ViewModel {

    // TODO: Use the ViewModel
    private MutableLiveData<Model> mRate = new MutableLiveData<>();


    public void setRate(Model rate) {
        mRate.setValue(rate);
    }

    public LiveData<Model> getRate() {
        return mRate;
    }

}