package com.example.td3;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PokeAPI {
    @GET("data.json")
    Call<RestPokemonResponse> getPokemonResponce();

}
