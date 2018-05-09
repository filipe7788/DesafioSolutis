package com.solutis.filiperibeiro.solutis.Service;

import android.graphics.Paint;

import com.solutis.filiperibeiro.solutis.Model.Capsula;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CapsulaService {

    @GET("capsulas")
    Call<ArrayList<Capsula>> buscarCAP();

    @DELETE("capsula/{id}")
    Call<Boolean> deleteCap(@Path("id") long id);

    @POST("capsula")
    Call<Capsula> salvaCap(@Body Capsula cap);

}
