package com.ews.androidrestapp.api;

/**
 * Created by wallace on 19/06/17.
 */
public class APIUtils {

    private APIUtils(){}

    public static final String BASE_URL = "http://www.mocky.io";

    public static AndroidAPI getAndroidAPI() {
        return RetrofitClient.getClient(BASE_URL).create(AndroidAPI.class);
    }

}
