package com.example.internationalspacestationapicall.model.datasource.remote.rxjava;

import com.example.internationalspacestationapicall.model.issresponse.ISSResponse;

public interface Callback {
    void getISSResponse(ISSResponse issResponse);
}
