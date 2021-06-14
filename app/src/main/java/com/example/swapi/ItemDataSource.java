package com.example.swapi;

//import android.arch.paging.PageKeyedDataSource;
import android.content.ClipData;
//import android.support.annotation.NonNull;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.nfc.tech.MifareUltralight.PAGE_SIZE;

public class ItemDataSource extends PageKeyedDataSource<Integer,Results> {

  //  public static final int PAGE_SIZE = 50;
    private static final int FIRST_PAGE = 1;
   // private static final String SITE_NAME = "stackoverflow";



    @Override
    public void loadInitial(@NonNull PageKeyedDataSource.LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, Results> callback) {

        RetrofitClient.getInstance()
                .getMyApi()
                .getPeople(FIRST_PAGE)
                .enqueue(new Callback<PeopleResponse>() {
                    @Override
                    public void onResponse(Call<PeopleResponse> call, Response<PeopleResponse> response) {

                        if(response.body() != null){

                            callback.onResult(response.body().getResults(), null, FIRST_PAGE + 1);

                        }

                    }

                    @Override
                    public void onFailure(Call<PeopleResponse> call, Throwable t) {

                    }
                });

    }

    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Results> callback) {

        RetrofitClient.getInstance()
                .getMyApi()
                .getPeople(params.key)
                .enqueue(new Callback<PeopleResponse>() {
                    @Override
                    public void onResponse(Call<PeopleResponse> call, Response<PeopleResponse> response) {



                        if(response.body() != null){
                            Integer key = (params.key > 1) ? params.key - 1 : null;
                            callback.onResult(response.body().getResults(), key);
                        }
                    }

                    @Override
                    public void onFailure(Call<PeopleResponse> call, Throwable t) {

                    }
                });

    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Results> callback) {

        RetrofitClient.getInstance()
                .getMyApi()
                .getPeople(params.key)
                .enqueue(new Callback<PeopleResponse>() {
                    @Override
                    public void onResponse(Call<PeopleResponse> call, Response<PeopleResponse> response) {

//                        if(response.body().getNext() != null){
//                            Integer key=params.key + 1;
//                                callback.onResult(response.body().getResults(), key);
//
//                            }
                        if(response.body() != null){
                            Integer key = (response.body().getNext() != null) ? params.key + 1 : null;
                            callback.onResult(response.body().getResults(), key);
                        }


                        }



                    @Override
                    public void onFailure(Call<PeopleResponse> call, Throwable t) {

                    }
                });


    }
}
