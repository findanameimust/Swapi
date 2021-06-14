package com.example.swapi;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


import static com.example.swapi.Api.BASE_URL;

public class RetrofitClient {

    private static RetrofitClient minstance;
    private Api myApi;

    private RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(Api.class);
    }

    public static synchronized RetrofitClient getInstance() {
        if (minstance == null) {
            minstance = new RetrofitClient();
        }
        return minstance;
    }

    public Api getMyApi() {
        return myApi;
    }
}