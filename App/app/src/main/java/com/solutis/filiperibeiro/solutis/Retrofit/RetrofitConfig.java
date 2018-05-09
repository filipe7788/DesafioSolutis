package com.solutis.filiperibeiro.solutis.Retrofit;

import com.google.gson.Gson;
import com.solutis.filiperibeiro.solutis.Service.CapsulaService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitConfig {

    private final Retrofit retrofit;

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("http://172.29.70.111:8080/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public CapsulaService getCAPService() {
        return this.retrofit.create(CapsulaService.class);
    }

}
