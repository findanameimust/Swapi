package com.example.swapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface Api {

    String BASE_URL = "https://swapi.dev/api/";

    /**
     * The return type is important here
     * The class structure that you've defined in Call<T>
     * should exactly match with your json response
     * If you are not using another api, and using the same as mine
     * then no need to worry, but if you have your own API, make sure
     * you change the return type appropriately
     **/
    @GET("people")
    Call<PeopleResponse> getPeople(@Query("page") int page);
                                   //@Query("pagesize") int pagesize);

    @GET
    Call<Film> getFilmData(@Url String url);

}