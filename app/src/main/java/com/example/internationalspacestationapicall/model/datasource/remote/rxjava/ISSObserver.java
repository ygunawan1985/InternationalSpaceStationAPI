package com.example.internationalspacestationapicall.model.datasource.remote.rxjava;

import android.util.Log;

import com.example.internationalspacestationapicall.model.issresponse.ISSResponse;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ISSObserver implements Observer<ISSResponse> {

    Callback callback;
    private ISSResponse issResponse;

    public ISSObserver(Callback callback) {
        this.callback = callback;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(ISSResponse issResponse) {
        this.issResponse = issResponse;
    }

    @Override
    public void onError(Throwable e) {
        Log.e("TAG_RX", "Whatever", e);
    }

    @Override
    public void onComplete() {
        callback.getISSResponse(issResponse);
    }
}
