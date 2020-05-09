package com.example.td3;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ListAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private SharedPreferences sharedPreferences;
    private Gson gson;

    private static final String BASE_URL = "https://raw.githubusercontent.com/Francois-Xavier-3A/Cards/master/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("application_esiea", Context.MODE_PRIVATE);
        gson = new GsonBuilder()
                .setLenient()
                .create();
        List<Monster> monsterList = getDataFromCache();

        if(monsterList != null){
            showList(monsterList);
        } else {
            makeApicall();
        }
    }

    private List<Monster> getDataFromCache() {
        String jsonMonster = sharedPreferences.getString(Constante.KEY_MONSTER_List, null);

        if(jsonMonster == null) {
            return null;
        } else
        {
            Type listType = new TypeToken<List<Monster>>(){}.getType();
            return gson.fromJson(jsonMonster, listType);
        }
    }

    private void showList(List<Monster> monsterList) {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // define an adapter
        mAdapter = new ListAdapter(monsterList, this);
        recyclerView.setAdapter(mAdapter);
    }

    private void makeApicall(){


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        DuelMastersAPI duelMastersAPI = retrofit.create(DuelMastersAPI.class);

        Call<RestMonsterResponse> call = duelMastersAPI.getMonsterResponce();
         call.enqueue(new Callback<RestMonsterResponse>() {
             @Override
             public void onResponse(Call<RestMonsterResponse> call, Response<RestMonsterResponse> response) {
                if(response.isSuccessful() && response.body() != null){
                    List<Monster> monsterList = response.body().getResults();
                    saveList(monsterList);
                    showList(monsterList);
                } else {
                    showError();
                }
             }

             @Override
             public void onFailure(Call<RestMonsterResponse> call, Throwable t) {
                showError();
             }

         });
    }

    private void saveList(List<Monster> monsterList) {
        String jsonString = gson.toJson(monsterList);

        sharedPreferences
                .edit()
                .putString(Constante.KEY_MONSTER_List, jsonString)
                .apply();

        Toast.makeText(getApplicationContext(), "List saved", Toast.LENGTH_SHORT).show();
    }

    private void showError() {
        Toast.makeText(getApplicationContext(), "API ERROR", Toast.LENGTH_SHORT).show();
    }
}
