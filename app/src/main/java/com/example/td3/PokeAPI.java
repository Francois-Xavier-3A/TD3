package com.example.td3;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PokeAPI {
    @GET("/api/v2/pokemon")
    Call<RestPokemonResponse> getPokemonResponce();

}
