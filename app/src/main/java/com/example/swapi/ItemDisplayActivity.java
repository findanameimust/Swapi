package com.example.swapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemDisplayActivity extends AppCompatActivity {
    List<String> film;
    List<String> species;
    TextView txtvw;
    String url;
    String surl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_display);
        txtvw=findViewById(R.id.txt);
        film=new ArrayList<>();
        species=new ArrayList<>();
        Results result= (Results) getIntent().getExtras().getSerializable("films");
        txtvw.setText(result.getName());
        species=result.getSpecies();

        for (int i=0;i<species.size();i++) {
            url = species.get(i);
            getFilm(url);
        }

        film = result.getFilms();
        for (int i=0;i<film.size();i++) {
            url = film.get(i);
            getFilm(url);
        }
//            txtvw.append(text.get(i)+"\n");




       // Log.d("fck", "onCreate: "+text);


    }
    public void getFilm(String url){
        Call<Film> call = RetrofitClient.getInstance().getMyApi().getFilmData(url);
//            //Execute the request in a background thread
        call.enqueue(new Callback<Film>(){

            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                Log.d("fck", "onCreate: "+response.body().title);

               // txtvw.setText(response.body().title+"\n"+response.body().director);




            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {

            }
        });
    }

    public void getSpecies(String surl){
        Call<Film> call = RetrofitClient.getInstance().getMyApi().getFilmData(url);
//            //Execute the request in a background thread
        call.enqueue(new Callback<Film>(){

            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                Log.d("fck", "onCreate: "+response.body().title);

                // txtvw.setText(response.body().title+"\n"+response.body().director);




            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {

            }
        });
    }

}