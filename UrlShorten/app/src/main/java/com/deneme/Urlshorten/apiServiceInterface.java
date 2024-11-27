package com.deneme.Urlshorten;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface apiServiceInterface {

    @POST("shorten")
    Call<ShortenResponse> shortenUrl(@Body shortenRequest request);
}