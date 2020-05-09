package com.example.td3;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DuelMastersAPI {
    @GET("data.json")
    Call<RestMonsterResponse> getMonsterResponce();

}
