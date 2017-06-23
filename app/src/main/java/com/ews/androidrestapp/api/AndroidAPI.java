package com.ews.androidrestapp.api;

import com.ews.androidrestapp.model.ResponseAndroid;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by wallace on 21/06/17.
 */

public interface AndroidAPI {

    @GET("/v2/58af1fb21000001e1cc94547")
    Call<ResponseAndroid> getVersoes();

}
