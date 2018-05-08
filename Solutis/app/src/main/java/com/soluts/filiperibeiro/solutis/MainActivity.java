package com.soluts.filiperibeiro.solutis;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.solutis.filiperibeiro.solutis.Model.Capsula;
import com.solutis.filiperibeiro.solutis.Retrofit.RetrofitConfig;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private SwipeMenuListView listaView;

    private ArrayList<Capsula> capsulas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaView = findViewById(R.id.lista);

        capsulas = new ArrayList<>();


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, form_activity.class);
                startActivity(it);
            }
        });


        SwipeMenuListView listView = listaView;
        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
                SwipeMenuItem openItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                openItem.setBackground(new ColorDrawable(Color.rgb(0x00, 0x66,
                        0xff)));
                // set item width
                openItem.setWidth(170);
                // set item title
                openItem.setTitle("Editar");
                // set item title fontsize
                openItem.setTitleSize(18);
                // set item title font color
                openItem.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(openItem);

                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                deleteItem.setTitle("Delete");
                deleteItem.setTitleColor(Color.WHITE);
                // set item width
                deleteItem.setWidth(170);

                menu.addMenuItem(deleteItem);
            }
        };



        listaView.setMenuCreator(creator);

        final Handler mainHandler = new Handler(getBaseContext().getMainLooper());
        final Runnable run = new Runnable() {
            @Override
            public void run() {
                final ArrayAdapter adapter = new CapsulaAdapter(getBaseContext(), capsulas);
                listaView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        };

        listaView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(final int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0:
                        Intent it = new Intent(MainActivity.this, form_activity.class);
                        startActivity(it);
                        break;
                    case 1:
                        new Thread(new Runnable(){
                            @Override
                            public void run() {
                                try {
                                     new RetrofitConfig().getCAPService().deleteCap(position+1).execute();
                                     capsulas.remove(position);
                                    mainHandler.post(run);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }            }
                        }).start();

                        break;
                }
                // false : close the menu; true : not close the menu
                return false;
            }
        });


        new Thread(new Runnable(){
            @Override
            public void run() {
                Call<ArrayList<Capsula>> call = new RetrofitConfig().getCAPService().buscarCAP();
                try {
                    capsulas = (call.execute().body());
                    Log.d("AR",  capsulas.toString());
                    mainHandler.post(run);
                } catch (IOException e) {
                    e.printStackTrace();
                }            }
        }).start();


    }

}
