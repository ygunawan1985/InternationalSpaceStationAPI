package com.example.internationalspacestationapicall.model.datasource.remote.retrofit;

import com.example.internationalspacestationapicall.model.datasource.remote.okhttp3.OkHttpHelper;
import com.example.internationalspacestationapicall.model.issresponse.ISSResponse;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.internationalspacestationapicall.model.datasource.remote.retrofit.UrlConstants.BASE_URL;

public class RetrofitHelper {
    static ISSResponse issResponse;

    public Retrofit getRetrofitInstance(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(OkHttpHelper.getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public ISSObservableService getObservableService(){
        return getRetrofitInstance().create(ISSObservableService.class);
    }
}
