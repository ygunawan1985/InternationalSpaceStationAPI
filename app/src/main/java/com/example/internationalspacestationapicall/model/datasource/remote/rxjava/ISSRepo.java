package com.example.internationalspacestationapicall.model.datasource.remote.rxjava;

import com.example.internationalspacestationapicall.model.datasource.remote.retrofit.RetrofitHelper;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ISSRepo {

    public static void getISS(Callback callback, String lat, String lon){
        new RetrofitHelper()
                .getObservableService()
                .getISSResponse(lat, lon)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ISSObserver(callback));
    }
}
