package com.soluts.filiperibeiro.solutis;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.solutis.filiperibeiro.solutis.Model.Capsula;
import com.solutis.filiperibeiro.solutis.Retrofit.RetrofitConfig;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class form_activity  extends AppCompatActivity {

    private static final String TAG = "form_activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_activity);

        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText sabor = findViewById(R.id.saborCapsula);
                EditText nome = findViewById(R.id.nomeCapsula);

                final Capsula novaCap = new Capsula(nome.getText().toString(), sabor.getText().toString());


                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Call<Capsula> call = new RetrofitConfig().getCAPService().salvaCap(novaCap);
                        try {
                            call.execute();
                            Intent it = new Intent(form_activity.this, MainActivity.class);
                            startActivity(it);
                        } catch (IOException e) {
                        }
                    }
                }).start();
            }
        });}}