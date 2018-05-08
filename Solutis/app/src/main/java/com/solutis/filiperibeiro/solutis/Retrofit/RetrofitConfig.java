package com.solutis.filiperibeiro.solutis.Retrofit;

import com.solutis.filiperibeiro.solutis.Service.CapsulaService;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    private final Retrofit retrofit;

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("http://172.29.40.60:8080/api/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public CapsulaService getCAPService() {
        return this.retrofit.create(CapsulaService.class);
    }

}
