package com.example.internationalspacestationapicall.model.datasource.remote.retrofit;

import com.example.internationalspacestationapicall.model.issresponse.ISSResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.example.internationalspacestationapicall.model.datasource.remote.retrofit.UrlConstants.PATH;
import static com.example.internationalspacestationapicall.model.datasource.remote.retrofit.UrlConstants.QUERY_LAT;
import static com.example.internationalspacestationapicall.model.datasource.remote.retrofit.UrlConstants.QUERY_LON;

public interface ISSObservableService {

    @GET(PATH)
    Observable<ISSResponse> getISSResponse(
            @Query(QUERY_LAT)String lat,
            @Query(QUERY_LON)String lon);
}
